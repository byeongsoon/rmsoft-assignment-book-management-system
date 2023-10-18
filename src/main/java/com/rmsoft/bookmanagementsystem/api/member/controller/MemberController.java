package com.rmsoft.bookmanagementsystem.api.member.controller;

import com.rmsoft.bookmanagementsystem.api.member.dto.MemberRequestDto;
import com.rmsoft.bookmanagementsystem.api.member.dto.MemberResponseDto;
import com.rmsoft.bookmanagementsystem.api.member.service.MemberInfoService;
import com.rmsoft.bookmanagementsystem.global.error.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

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
@Tag(name = "사용자 정보", description = "사용자 관련 API")
public class MemberController {

    private final MemberInfoService memberService;

    @Operation(summary = "회원가입 요청", description = "사용자 정보가 등록됩니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = MemberResponseDto.class))),
        @ApiResponse(responseCode = "409", description = "이미 존재하는 회원입니다.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<MemberResponseDto> register(
        @Parameter(description = "사용자 정보 등록에 필요한 데이터") @RequestBody @Valid MemberRequestDto requestDto
    ) {
        MemberResponseDto responseDto = memberService.register(requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
