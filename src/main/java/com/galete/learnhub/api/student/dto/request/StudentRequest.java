package com.galete.learnhub.api.student.dto.request;

import com.galete.learnhub.api.user.entity.User;
import jakarta.validation.constraints.NotNull;

public record StudentRequest(
        @NotNull Boolean enabled,
        @NotNull User user
) {
}
