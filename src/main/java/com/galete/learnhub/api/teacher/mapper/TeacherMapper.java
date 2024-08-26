package com.galete.learnhub.api.teacher.mapper;

import com.galete.learnhub.api.teacher.dto.request.TeacherRequest;
import com.galete.learnhub.api.teacher.dto.response.TeacherResponse;
import com.galete.learnhub.api.teacher.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface TeacherMapper {
    Teacher toEntity(TeacherRequest teacherRequest);

    TeacherResponse toDTO(Teacher teacher);
}
