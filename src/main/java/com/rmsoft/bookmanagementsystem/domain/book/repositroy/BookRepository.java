package com.rmsoft.bookmanagementsystem.domain.book.repositroy;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
