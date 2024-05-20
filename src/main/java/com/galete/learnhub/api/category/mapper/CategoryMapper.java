package com.galete.learnhub.api.category.mapper;

import com.galete.learnhub.api.category.dto.requests.CategoryRequest;
import com.galete.learnhub.api.category.dto.responses.CategoryResponse;
import com.galete.learnhub.api.category.entity.Category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryMapper {


    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Category categoryRequestToCategory(CategoryRequest request);


    CategoryResponse categoryToCategoryResponse(Category category);

}
