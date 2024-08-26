package com.galete.learnhub.api.teacher.dto.response;

import com.galete.learnhub.api.student.dto.response.UserResponse;

public record TeacherResponse(
        Boolean enabled,
        UserResponse user
) {
}
