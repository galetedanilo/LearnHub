package com.galete.learnhub.api.teacher.controller;

import com.galete.learnhub.api.teacher.dto.request.TeacherRequest;
import com.galete.learnhub.api.teacher.dto.response.TeacherResponse;
import com.galete.learnhub.api.teacher.entity.Teacher;
import com.galete.learnhub.api.teacher.mapper.TeacherMapper;
import com.galete.learnhub.api.teacher.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @PostMapping
    public ResponseEntity<TeacherResponse> createTeacher(@RequestBody @Valid TeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.toEntity(teacherRequest);
        teacher = teacherService.create(teacher);

        TeacherResponse teacherResponse = teacherMapper.toDTO(teacher);

        return new ResponseEntity<>(teacherResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<TeacherResponse>> findAll(Pageable pageable) {
        Page<Teacher> teacherPage = teacherService.findAll(pageable);

        Page<TeacherResponse> teacherResponsePage = teacherPage.map(teacherMapper::toDTO);

        return new ResponseEntity<>(teacherResponsePage, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<TeacherResponse> findById(@PathVariable Long id) {
        Teacher teacher = teacherService.findById(id);

        TeacherResponse teacherResponse = teacherMapper.toDTO(teacher);

        return new ResponseEntity<>(teacherResponse, HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<TeacherResponse> update(@PathVariable Long id, @RequestBody @Valid TeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.toEntity(teacherRequest);

        teacher = teacherService.update(id, teacher);

        TeacherResponse teacherResponse = teacherMapper.toDTO(teacher);

        return ResponseEntity.ok(teacherResponse);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teacherService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
