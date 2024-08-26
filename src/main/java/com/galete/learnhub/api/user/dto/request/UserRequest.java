package com.galete.learnhub.api.user.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "First name is required")
        @Size(max = 50, message = "Maximum 50 characters")
        String firstName,
        @NotBlank(message = "Last name is required")
        @Size(max = 50, message = "Maximum 50 characters")
        String lastName,
        String picture,
        @Valid AddressRequest address,
        @Valid ContactRequest contact
) {
}
