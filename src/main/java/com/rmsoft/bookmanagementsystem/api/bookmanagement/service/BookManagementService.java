package com.rmsoft.bookmanagementsystem.api.bookmanagement.service;

import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookRequestDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookResponseDto;
import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.book.service.BookService;
import com.rmsoft.bookmanagementsystem.domain.bookloan.model.BookLoanHistory;
import com.rmsoft.bookmanagementsystem.domain.bookloan.service.BookLoanHistoryService;
import com.rmsoft.bookmanagementsystem.domain.member.model.Member;
import com.rmsoft.bookmanagementsystem.domain.member.service.MemberService;
import com.rmsoft.bookmanagementsystem.global.error.exception.BusinessException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookManagementService {

    private final BookService bookService;

    private final MemberService memberService;

    private final BookLoanHistoryService bookLoanHistoryService;


    @Transactional
    public BookResponseDto.BookInfo register(final BookRequestDto.Register requestDto) {
        Book newBook = BookRequestDto.Register.toEntity(requestDto);
        Book savedBook = bookService.save(newBook);

        return BookResponseDto.BookInfo.of(savedBook);
    }

    @Transactional
    public BookResponseDto.BookInfo update(final BookRequestDto.Update requestDto) {
        Book findBook = bookService.findById(requestDto.getId());
        findBook.updateInformation(requestDto.getAuthor(), requestDto.getPublisher(), requestDto.getPublicationDate());

        return BookResponseDto.BookInfo.of(findBook);
    }

    public BookResponseDto.Loan loan(final BookRequestDto.Loan requestDto) {
        Book book = bookService.findByTitle(requestDto.getTitle());
        Member member = memberService.findByUserId(requestDto.getUserId());

        if (!bookLoanHistoryService.isLoanPossible(book)) {
            throw new BusinessException(400, "해당 책은 이미 대출되어 있습니다.");
        }

        BookLoanHistory loanHistory = BookRequestDto.Loan.toEntity(book,member);
        BookLoanHistory savedLoanHistory = bookLoanHistoryService.save(loanHistory);

        return BookResponseDto.Loan.of(book.getTitle(), member.getName(), savedLoanHistory.getLoanDate());
    }

    @Transactional
    public void returnBook(final String title) {
        Book book = bookService.findByTitle(title);
        BookLoanHistory loanHistory = bookLoanHistoryService.findHistoryByBook(book);

        loanHistory.bookReturn();
    }

    public List<BookResponseDto.LoanHistory> getResponseDtos(final String title) {
        Book book = bookService.findByTitle(title);
        List<BookLoanHistory> loanHistories = bookLoanHistoryService.findAllHistory(book);

        return loanHistories.stream()
            .map(BookResponseDto.LoanHistory::from)
            .collect(Collectors.toList());
    }

}
