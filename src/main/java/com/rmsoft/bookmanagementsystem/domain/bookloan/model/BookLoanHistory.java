package com.rmsoft.bookmanagementsystem.domain.bookloan.model;

import com.rmsoft.bookmanagementsystem.domain.book.model.Book;
import com.rmsoft.bookmanagementsystem.domain.common.BaseEntity;
import com.rmsoft.bookmanagementsystem.domain.member.model.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookLoanHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private Boolean isReturn;

    private LocalDateTime loanDate;

    private LocalDateTime returnDate;

    public void bookReturn() {
        this.isReturn = true;
        this.returnDate = LocalDateTime.now();
    }

}
