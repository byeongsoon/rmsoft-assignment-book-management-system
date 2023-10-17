package com.rmsoft.bookmanagementsystem.domain.book.model;

import com.rmsoft.bookmanagementsystem.domain.common.BaseEntity;

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
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50, nullable = false)
    private String title;

    @Column(length = 30, nullable = false)
    private String author;

    private String publisher;

    private String category;

    private LocalDateTime publicationDate;

}
