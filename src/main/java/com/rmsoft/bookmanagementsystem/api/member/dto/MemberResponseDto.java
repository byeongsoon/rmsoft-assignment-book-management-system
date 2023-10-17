package com.rmsoft.bookmanagementsystem.api.member.dto;

import com.rmsoft.bookmanagementsystem.domain.member.model.Member;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {

    private Long id;

    private String name;

    private Integer age;

    private String address;

    private String phoneNumber;

    private String userId;

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
            .id(member.getId())
            .name(member.getName())
            .age(member.getAge())
            .address(member.getAddress())
            .phoneNumber(member.getPhoneNumber())
            .userId(member.getUserId())
            .build();
    }

}
