package com.rmsoft.bookmanagementsystem.api.member.dto;

import com.rmsoft.bookmanagementsystem.domain.member.model.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequestDto {

    private String name;

    private Integer age;

    private String address;

    private String phoneNumber;

    private String userId;

    public static Member toEntity(MemberRequestDto requestDto) {
        return Member.builder()
            .name(requestDto.name)
            .age(requestDto.age)
            .address(requestDto.address)
            .phoneNumber(requestDto.phoneNumber)
            .userId(requestDto.userId)
            .build();
    }

}
