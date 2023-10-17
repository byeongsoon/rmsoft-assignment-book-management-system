package com.rmsoft.bookmanagementsystem.api.member.dto;

import com.rmsoft.bookmanagementsystem.domain.member.model.Member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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
            .name(requestDto.name)
            .age(requestDto.age)
            .address(requestDto.address)
            .phoneNumber(requestDto.phoneNumber)
            .userId(requestDto.userId)
            .build();
    }

}
