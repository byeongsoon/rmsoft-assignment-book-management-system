package com.rmsoft.bookmanagementsystem.api.bookmanagement.dto;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;

import jakarta.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public interface BookRequestDto {

    @Getter
    @Builder
    class Register {
        @NotEmpty
        private String title;

        @NotEmpty
        private String author;

        private String publisher;

        private String category;

        private LocalDateTime publicationDate;

        public static Book toEntity(BookRequestDto.Register requestDto) {
            return Book.builder()
                .title(requestDto.getTitle())
                .author(requestDto.getAuthor())
                .publisher(requestDto.getPublisher())
                .category(requestDto.getCategory())
                .publicationDate(requestDto.getPublicationDate())
                .build();
        }
    }

}
