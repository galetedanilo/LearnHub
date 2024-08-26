package com.galete.learnhub.api.course.dto.request;


import com.galete.learnhub.api.student.entity.Student;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CourseRequest(
        @NotNull String title,
        @NotNull String description,
        @NotNull String author
) {
}
