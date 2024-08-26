package com.galete.learnhub.api.teacher.dto.request;

import com.galete.learnhub.api.user.entity.User;
import jakarta.validation.constraints.NotNull;

public record TeacherRequest(
        @NotNull Boolean enable,
        @NotNull User user) {
}
