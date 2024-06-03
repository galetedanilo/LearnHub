package com.galete.learnhub.api.subcategory.dto.request;

import com.galete.learnhub.api.category.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SubcategoryRequest(
        @NotNull
        Category category,
        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Maximum 100 characters")
        String name,
        @Size(max = 500, message = "Maximum 500 characters")
        String description,
        @NotNull(message = "Active is required")
        Boolean active) {
}
