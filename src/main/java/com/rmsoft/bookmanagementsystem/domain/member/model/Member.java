package com.rmsoft.bookmanagementsystem.domain.member.model;

import com.rmsoft.bookmanagementsystem.domain.common.BaseEntity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    private String address;

    @Column(unique = true, length = 30, nullable = false)
    private String phoneNumber;

    @Column(unique = true, length = 20, nullable = false)
    private String userId;

}
