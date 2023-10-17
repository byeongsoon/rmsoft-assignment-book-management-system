package com.rmsoft.bookmanagementsystem.api.bookmanagement.dto;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BookResponseDto {

    private Long id;

    private String title;

    private String author;

    private String publisher;

    private String category;

    private LocalDateTime publicationDate;

    public static BookResponseDto of(Book book) {
        return BookResponseDto.builder()
            .id(book.getId())
            .title(book.getTitle())
            .author(book.getAuthor())
            .publisher(book.getPublisher())
            .category(book.getCategory())
            .publicationDate(book.getPublicationDate())
            .build();
    }


}
