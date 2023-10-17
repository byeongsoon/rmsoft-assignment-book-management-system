package com.rmsoft.bookmanagementsystem.domain.bookloan.service;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.bookloan.model.BookLoanHistory;
import com.rmsoft.bookmanagementsystem.domain.bookloan.repository.BookLoanHistoryRepository;
import com.rmsoft.bookmanagementsystem.global.error.exception.BusinessException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookLoanHistoryService {

    private final BookLoanHistoryRepository bookLoanHistoryRepository;

    @Transactional
    public BookLoanHistory save(final BookLoanHistory loanHistory) {
        return bookLoanHistoryRepository.save(loanHistory);
    }

    public boolean isLoanPossible(Book book) {
        Optional<BookLoanHistory> loanHistories = bookLoanHistoryRepository.findByBookAndIsReturn(book, false);

        return loanHistories.isEmpty();
    }

    public BookLoanHistory findByHistory(final Book book) {
        Optional<BookLoanHistory> loanHistory = bookLoanHistoryRepository.findByBookAndIsReturn(book, false);

        if (loanHistory.isEmpty()) {
            throw new BusinessException(400, "해당 책의 대출 기록이 없습니다.");
        }

        return loanHistory.get();
    }
}
