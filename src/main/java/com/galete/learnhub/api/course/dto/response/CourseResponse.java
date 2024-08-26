package com.galete.learnhub.api.course.dto.response;

import com.galete.learnhub.api.category.entity.Category;
import com.galete.learnhub.api.student.entity.Student;

import java.util.Set;

public record CourseResponse(
        Long id,
        String title,
        String description,
        String author
) {
}
