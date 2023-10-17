package com.rmsoft.bookmanagementsystem.global.error;

import com.rmsoft.bookmanagementsystem.global.error.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Business 예외
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        log.error("BusinessException : ", e);
        List<String> errorMessages = List.of(e.getMessage());
        HttpStatus httpStatus = HttpStatus.valueOf(e.getStatus());
        ErrorResponse errorResponse = ErrorResponse.of(httpStatus, errorMessages);
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    /**
     * Validation 예외
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException : ", e);

        List<String> errorMessages = List.of(e.getMessage().split("default message")[2]);
        HttpStatus httpStatus = HttpStatus.valueOf(e.getStatusCode().value());
        ErrorResponse errorResponse = ErrorResponse.of(httpStatus, errorMessages);
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

}
