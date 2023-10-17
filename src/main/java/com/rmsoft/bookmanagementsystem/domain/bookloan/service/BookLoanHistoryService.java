package com.rmsoft.bookmanagementsystem.domain.bookloan.service;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.bookloan.model.BookLoanHistory;
import com.rmsoft.bookmanagementsystem.domain.bookloan.repository.BookLoanHistoryRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        List<BookLoanHistory> loanHistories = bookLoanHistoryRepository.findByBookAndIsReturn(book, false);

        return loanHistories.isEmpty();
    }

}
