package com.rmsoft.bookmanagementsystem.api.bookmanagement.service;

import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookRequestDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookResponseDto;
import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.book.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookManagementService {

    private final BookService bookService;


    @Transactional
    public BookResponseDto register(final BookRequestDto.Register requestDto) {
        Book newBook = BookRequestDto.Register.toEntity(requestDto);
        Book savedBook = bookService.save(newBook);

        return BookResponseDto.of(savedBook);
    }

    @Transactional
    public BookResponseDto update(final BookRequestDto.Update requestDto) {
        Book findBook = bookService.findById(requestDto.getId());
        findBook.updateInformation(requestDto.getAuthor(), requestDto.getPublisher(), requestDto.getPublicationDate());

        return BookResponseDto.of(findBook);
    }

}
