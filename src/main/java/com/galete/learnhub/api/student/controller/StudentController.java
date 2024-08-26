package com.galete.learnhub.api.student.controller;

import com.galete.learnhub.api.student.dto.request.StudentRequest;
import com.galete.learnhub.api.student.dto.response.StudentResponse;
import com.galete.learnhub.api.student.entity.Student;
import com.galete.learnhub.api.student.mapper.StudentMapper;
import com.galete.learnhub.api.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        Student student = studentMapper.toEntity(studentRequest);
        student = studentService.create(student);

        StudentResponse studentResponse = studentMapper.toDTO(student);

        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<Page<StudentResponse>> findAll(Pageable pageable) {
        Page<Student> studentPage = studentService.findAll(pageable);

        Page<StudentResponse> studentResponses = studentPage.map(studentMapper::toDTO);

        return ResponseEntity.ok(studentResponses);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id) {
        Student student = studentService.findById(id);

        StudentResponse studentResponse = studentMapper.toDTO(student);

        return ResponseEntity.ok(studentResponse);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable Long id, @Valid @RequestBody StudentRequest studentRequest) {
        Student student = studentMapper.toEntity(studentRequest);

        student = studentService.update(id, student);

        StudentResponse studentResponse = studentMapper.toDTO(student);

        return ResponseEntity.ok(studentResponse);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.remove(id);

        return ResponseEntity.noContent().build();
    }

}
