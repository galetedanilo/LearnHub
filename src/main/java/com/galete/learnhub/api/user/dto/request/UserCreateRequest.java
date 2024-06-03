package com.galete.learnhub.api.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
        @NotBlank(message = "First name is required")
        @Size(max = 50, message = "Maximum 50 characters")
        String firstName,
        @NotBlank(message = "Last name is required")
        @Size(max = 50, message = "Maximum 50 characters")
        String lastName,
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email")
        String email,
        @NotBlank(message = "Password is required")
        @Size(max = 15, message = "Maximum 15 characters")
        String password
) {
}
