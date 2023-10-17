package com.rmsoft.bookmanagementsystem.api.bookmanagement.dto;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;

import com.rmsoft.bookmanagementsystem.domain.bookloan.model.BookLoanHistory;
import com.rmsoft.bookmanagementsystem.domain.member.model.Member;

import jakarta.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Getter
    @Builder
    class Update {
        private Long id;

        private String author;

        private String publisher;

        private LocalDateTime publicationDate;
    }

    @Getter
    @Builder
    class Loan{
        @NotEmpty
        private String title;

        @NotEmpty
        private String userId;

        public static BookLoanHistory toEntity(Book book, Member member) {
            return  BookLoanHistory.builder()
                .book(book)
                .member(member)
                .isReturn(false)
                .loanDate(LocalDateTime.now())
                .build();
        }
    }

    @Getter
    @NoArgsConstructor
    class BookReturn {
        @NotEmpty
        private String title;
    }

}
