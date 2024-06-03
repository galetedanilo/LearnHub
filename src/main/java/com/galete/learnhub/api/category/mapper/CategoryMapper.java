package com.galete.learnhub.api.category.mapper;

import com.galete.learnhub.api.category.dto.request.CategoryRequest;
import com.galete.learnhub.api.category.dto.responses.CategoryResponse;
import com.galete.learnhub.api.category.entity.Category;

import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category toEntity(CategoryRequest request);


    CategoryResponse toDTO(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryRequestFromCategory(CategoryRequest categoryRequest, @MappingTarget Category category);

}
