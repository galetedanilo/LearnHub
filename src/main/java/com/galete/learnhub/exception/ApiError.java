package com.galete.learnhub.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiError(
        HttpStatus status,
        Integer statusCode,
        LocalDateTime timestamp,
        String message,
        String path) {
}
