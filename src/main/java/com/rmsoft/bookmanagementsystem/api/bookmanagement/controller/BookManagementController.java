package com.rmsoft.bookmanagementsystem.api.bookmanagement.controller;

import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookRequestDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookResponseDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.service.BookManagementService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookManagementController {

    private final BookManagementService bookManagementService;

    @PostMapping
    public ResponseEntity<BookResponseDto.BookInfo> register(@RequestBody @Valid BookRequestDto.Register requestDto) {
        BookResponseDto.BookInfo responseDto = bookManagementService.register(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping
    public ResponseEntity<BookResponseDto.BookInfo> updateBookInformation(@RequestBody @Valid BookRequestDto.Update requestDto) {
        BookResponseDto.BookInfo responseDto = bookManagementService.update(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/loans")
    public ResponseEntity<List<BookResponseDto.LoanHistory>> findHistory(@RequestParam String title) {
        List<BookResponseDto.LoanHistory> loanHistories = bookManagementService.getResponseDtos(title);
        return ResponseEntity.ok(loanHistories);
    }

    @PostMapping("/loans")
    public ResponseEntity<BookResponseDto.Loan> loanBook(@RequestBody @Valid BookRequestDto.Loan requestDto) {
        BookResponseDto.Loan responseDto = bookManagementService.loan(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("/loans")
    public ResponseEntity<String> returnBook(@RequestBody @Valid BookRequestDto.BookReturn requestDto) {
        bookManagementService.returnBook(requestDto.getTitle());
        return ResponseEntity.ok("정상 반납 되었습니다.");
    }

}
