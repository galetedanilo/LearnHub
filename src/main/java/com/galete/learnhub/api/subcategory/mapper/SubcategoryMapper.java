package com.galete.learnhub.api.subcategory.mapper;

import com.galete.learnhub.api.category.entity.Category;
import com.galete.learnhub.api.subcategory.dto.request.SubcategoryRequest;
import com.galete.learnhub.api.subcategory.dto.response.SubcategoryResponse;
import com.galete.learnhub.api.subcategory.entity.Subcategory;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubcategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Subcategory toEntity(SubcategoryRequest subcategoryRequest);

    SubcategoryResponse toDTO(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSubcategoryRequestToSubcategory(SubcategoryRequest subcategoryRequest, @MappingTarget Subcategory subcategory);
}
