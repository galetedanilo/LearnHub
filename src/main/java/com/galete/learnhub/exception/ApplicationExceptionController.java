package com.galete.learnhub.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationExceptionController {

    @ExceptionHandler(value = ResourceNotFound.class)
    public ResponseEntity<ApiError> resourceNotFoundException(ResourceNotFound exception, HttpServletRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                request.getRequestURL().toString());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
