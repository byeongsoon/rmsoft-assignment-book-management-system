package com.rmsoft.bookmanagementsystem.domain.bookloan.repository;

import com.rmsoft.bookmanagementsystem.domain.bookloan.model.BookLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanHistoryRepository extends JpaRepository<BookLoanHistory, Long> {
}
