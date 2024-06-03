package com.galete.learnhub.api.user.dto.response;

public record UserResponse(
        String firstName,
        String lastName,
        String email,
        AddressResponse address,
        ContactResponse contact
) {
}
