package com.rmsoft.bookmanagementsystem.api.bookmanagement.controller;

import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookRequestDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookResponseDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.service.BookManagementService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookManagementController {

    private final BookManagementService bookManagementService;

    @PostMapping
    public ResponseEntity<BookResponseDto> register(@RequestBody @Valid BookRequestDto.Register requestDto) {
        BookResponseDto responseDto = bookManagementService.register(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping
    public ResponseEntity<BookResponseDto> updateBookInformation(@RequestBody @Valid BookRequestDto.Update requestDto) {
        BookResponseDto responseDto = bookManagementService.update(requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
