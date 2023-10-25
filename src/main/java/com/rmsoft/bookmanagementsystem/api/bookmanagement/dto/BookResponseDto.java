package com.rmsoft.bookmanagementsystem.api.bookmanagement.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.bookloan.model.BookLoanHistory;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public interface BookResponseDto {

    @Getter
    @Builder
    class BookInfo {
        private Long id;

        private String title;

        private String author;

        private String publisher;

        private String category;

        private LocalDateTime publicationDate;

        public static BookResponseDto.BookInfo of(Book book) {
            return BookResponseDto.BookInfo.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .category(book.getCategory())
                .publicationDate(book.getPublicationDate())
                .build();
        }
    }

    @Getter
    @Builder
    class LoanResult {
        private String title;

        private String memberName;

        private LocalDateTime loanDate;

        public static LoanResult of(String title, String memberName, LocalDateTime loanDate) {
            return LoanResult.builder()
                .title(title)
                .memberName(memberName)
                .loanDate(loanDate)
                .build();
        }
    }

    @Getter
    @Builder
    class LoanHistory {
        private Long id;

        private String bookTitle;

        private String memberName;

        private boolean isReturn;

        private LocalDateTime loanDate;

        private LocalDateTime returnDate;

        public static BookResponseDto.LoanHistory from(BookLoanHistory loanHistory) {
            return LoanHistory.builder()
                .id(loanHistory.getId())
                .bookTitle(loanHistory.getBook().getTitle())
                .memberName(loanHistory.getMember().getName())
                .isReturn(loanHistory.getIsReturn())
                .loanDate(loanHistory.getLoanDate())
                .returnDate(loanHistory.getReturnDate())
                .build();
        }
    }

}
