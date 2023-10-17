package com.rmsoft.bookmanagementsystem.domain.bookloan.repository;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.bookloan.model.BookLoanHistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookLoanHistoryRepository extends JpaRepository<BookLoanHistory, Long> {

    Optional<BookLoanHistory> findByBookAndIsReturn(final Book book, final boolean isReturn);

    List<BookLoanHistory> findAllByBook(final Book book);

}
