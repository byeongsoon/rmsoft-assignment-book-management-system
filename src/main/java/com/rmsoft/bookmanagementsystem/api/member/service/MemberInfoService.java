package com.rmsoft.bookmanagementsystem.api.member.service;

import com.rmsoft.bookmanagementsystem.api.member.dto.MemberRequestDto;
import com.rmsoft.bookmanagementsystem.api.member.dto.MemberResponseDto;
import com.rmsoft.bookmanagementsystem.domain.member.service.MemberService;
import com.rmsoft.bookmanagementsystem.domain.member.model.Member;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberInfoService {

    private final MemberService memberService;

    public MemberResponseDto register(final MemberRequestDto requestDto) {
        Member newMember = MemberRequestDto.toEntity(requestDto);
        Member savedMember = memberService.save(newMember);

        return MemberResponseDto.of(savedMember);
    }

}
