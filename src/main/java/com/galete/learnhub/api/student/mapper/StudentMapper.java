package com.galete.learnhub.api.student.mapper;

import com.galete.learnhub.api.student.dto.request.StudentRequest;
import com.galete.learnhub.api.student.dto.response.StudentResponse;
import com.galete.learnhub.api.student.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    Student toEntity(StudentRequest studentRequest);

    StudentResponse toDTO(Student student);
}
