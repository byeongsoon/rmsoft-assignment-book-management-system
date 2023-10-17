package com.rmsoft.bookmanagementsystem.domain.book.service;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.book.repositroy.BookRepository;
import com.rmsoft.bookmanagementsystem.domain.member.model.Member;
import com.rmsoft.bookmanagementsystem.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public Book save(final Book newBook) {
        Optional<Book> findBook = bookRepository.findByTitle(newBook.getTitle());

        if (findBook.isPresent()) {
            throw new BusinessException(409, "이미 등록된 책 입니다.");
        }

        return bookRepository.save(newBook);
    }

    public Book findById(final Long id) {
        Optional<Book> findBook = bookRepository.findById(id);

        if (findBook.isEmpty()) {
            throw new BusinessException(400, "해당 책은 등록되어있지 않습니다.");
        }

        return findBook.get();
    }
}
