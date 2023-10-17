package com.rmsoft.bookmanagementsystem.api.bookmanagement.service;

import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookRequestDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookResponseDto;
import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookManagementService {

    private final BookService bookService;


    public BookResponseDto.Register register(final BookRequestDto.Register requestDto) {
        Book newBook = BookRequestDto.Register.toEntity(requestDto);
        Book savedBook = bookService.save(newBook);

        return BookResponseDto.Register.of(savedBook);
    }
}
