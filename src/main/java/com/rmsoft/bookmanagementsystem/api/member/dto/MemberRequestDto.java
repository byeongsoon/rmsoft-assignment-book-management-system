package com.rmsoft.bookmanagementsystem.api.member.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import com.rmsoft.bookmanagementsystem.domain.member.model.Member;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberRequestDto {

    @NotEmpty
    private String name;

    private Integer age;

    private String address;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String userId;

    public static Member toEntity(MemberRequestDto requestDto) {
        return Member.builder()
            .name(requestDto.getName())
            .age(requestDto.getAge())
            .address(requestDto.getAddress())
            .phoneNumber(requestDto.getPhoneNumber())
            .userId(requestDto.getUserId())
            .build();
    }

}
