package com.galete.learnhub.api.course.mapper;

import com.galete.learnhub.api.course.dto.request.CourseRequest;
import com.galete.learnhub.api.course.dto.response.CourseResponse;
import com.galete.learnhub.api.course.entity.Course;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Course toEntity(CourseRequest courseRequest);

    CourseResponse toDTO(Course course);
}
