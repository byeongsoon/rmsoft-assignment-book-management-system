package com.rmsoft.bookmanagementsystem.api.bookmanagement.controller;

import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookRequestDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookResponseDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.service.BookManagementService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookManagementController {

    private final BookManagementService bookManagementService;

    @PostMapping
    public ResponseEntity<BookResponseDto.Register> register(@RequestBody @Valid BookRequestDto.Register requestDto) {
        BookResponseDto.Register responseDto = bookManagementService.register(requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
