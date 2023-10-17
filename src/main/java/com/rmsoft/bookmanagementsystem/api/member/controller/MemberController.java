package com.rmsoft.bookmanagementsystem.api.member.controller;

import com.rmsoft.bookmanagementsystem.api.member.dto.MemberRequestDto;
import com.rmsoft.bookmanagementsystem.api.member.dto.MemberResponseDto;
import com.rmsoft.bookmanagementsystem.api.member.service.MemberInfoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberInfoService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> register(@RequestBody @Valid MemberRequestDto requestDto) {
        MemberResponseDto responseDto = memberService.register(requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
