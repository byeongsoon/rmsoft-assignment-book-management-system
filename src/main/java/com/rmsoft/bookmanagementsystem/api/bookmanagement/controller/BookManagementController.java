package com.rmsoft.bookmanagementsystem.api.bookmanagement.controller;

import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookRequestDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.dto.BookResponseDto;
import com.rmsoft.bookmanagementsystem.api.bookmanagement.service.BookManagementService;
import com.rmsoft.bookmanagementsystem.global.error.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
@Tag(name = "도서 관리", description = "도서관리에 필요한 API")
public class BookManagementController {

    private final BookManagementService bookManagementService;

    @Operation(summary = "도서 정보 등록 요청", description = "도서 정보가 등록됩니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공",
            content = @Content(schema = @Schema(implementation = BookResponseDto.BookInfo.class))),
        @ApiResponse(responseCode = "409", description = "이미 등록된 책 입니다.",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<BookResponseDto.BookInfo> register(
        @Parameter(description = "도서 정보 등록에 필요한 데이터") @RequestBody @Valid BookRequestDto.Register requestDto
    ) {
        BookResponseDto.BookInfo responseDto = bookManagementService.register(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "도서 정보 수정 요청", description = "도서 정보가 수정됩니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공",
            content = @Content(schema = @Schema(implementation = BookResponseDto.BookInfo.class))),
        @ApiResponse(responseCode = "400", description = "해당 책은 등록되어있지 않습니다.",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PatchMapping
    public ResponseEntity<BookResponseDto.BookInfo> updateBookInformation(
        @Parameter(description = "도서 정보 수정에 필요한 데이터") @RequestBody @Valid BookRequestDto.Update requestDto
    ) {
        BookResponseDto.BookInfo responseDto = bookManagementService.update(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "도서 대출이력 조회 요청", description = "도서의 대출이력 정보가 출력됩니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공",
            content = @Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = BookResponseDto.LoanHistory.class)))),
        @ApiResponse(responseCode = "204", description = "해당 책의 대출이력이 없습니다.",
            content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "400", description = "해당 책은 등록되어있지 않습니다.",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/loans")
    public ResponseEntity<List<BookResponseDto.LoanHistory>> findHistory(
        @Parameter(description = "대출이력 조회를 위한 도서 제목") @RequestParam String title
    ) {
        List<BookResponseDto.LoanHistory> loanHistories = bookManagementService.getResponseDtos(title);
        return ResponseEntity.ok(loanHistories);
    }

    @Operation(summary = "도서 대출 요청", description = "도서를 대출합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공",
            content = @Content(schema = @Schema(implementation = BookResponseDto.Loan.class))),
        @ApiResponse(responseCode = "403", description = "해당 책은 등록되어있지 않습니다.",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "400", description = "해당 책은 이미 대출되어 있습니다.",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "409", description = "존재하지 않는 회원입니다.",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/loans")
    public ResponseEntity<BookResponseDto.Loan> loanBook(
        @Parameter(description = "도서 대출 요청을 위한 사용자ID, 도서 제목") @RequestBody @Valid BookRequestDto.Loan requestDto
    ) {
        BookResponseDto.Loan responseDto = bookManagementService.loan(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "도서 반납 요청", description = "도서를 반납합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공",
            content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "403", description = "해당 책은 등록되어있지 않습니다.",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "400", description = "해당 책의 대출기록이 없습니다.",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PatchMapping("/loans")
    public ResponseEntity<String> returnBook(
        @Parameter(description = "도서 반납에 필요한 도서 제목") @RequestBody @Valid BookRequestDto.BookReturn requestDto
    ) {
        bookManagementService.returnBook(requestDto.getTitle());
        return ResponseEntity.ok("정상 반납 되었습니다.");
    }

}
