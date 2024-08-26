package com.galete.learnhub.api.student.dto.response;

public record StudentResponse(
        Boolean enabled,
        UserResponse user
) {
}
