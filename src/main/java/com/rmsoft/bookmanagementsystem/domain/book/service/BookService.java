package com.rmsoft.bookmanagementsystem.domain.book.service;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.book.repositroy.BookRepository;
import com.rmsoft.bookmanagementsystem.domain.member.model.Member;
import com.rmsoft.bookmanagementsystem.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(final Book newBook) {
        Optional<Book> findBook = bookRepository.findByTitle(newBook.getTitle());

        if (findBook.isPresent()) {
            throw new BusinessException(409, "이미 등록된 책 입니다.");
        }

        return bookRepository.save(newBook);
    }
}
