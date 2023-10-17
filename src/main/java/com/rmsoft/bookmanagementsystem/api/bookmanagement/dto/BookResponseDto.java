package com.rmsoft.bookmanagementsystem.api.bookmanagement.dto;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public interface BookResponseDto {

    @Getter
    @Builder
    class Register {
        private Long id;

        private String title;

        private String author;

        private String publisher;

        private String category;

        private LocalDateTime publicationDate;

        public static BookResponseDto.Register of(Book book) {
            return Register.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .category(book.getCategory())
                .publicationDate(book.getPublicationDate())
                .build();
        }
    }

}
