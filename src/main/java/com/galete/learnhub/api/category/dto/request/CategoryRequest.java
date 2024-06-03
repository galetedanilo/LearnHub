package com.galete.learnhub.api.category.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 200, message = "Maximum 200 characters")
    private String name;

    @Size(max = 1000, message = "Maximum 1,000 characters")
    private String description;

    @NotNull
    private Boolean active;
}
