package com.galete.learnhub.api.course.controller;

import com.galete.learnhub.api.course.dto.request.CourseRequest;
import com.galete.learnhub.api.course.dto.response.CourseResponse;
import com.galete.learnhub.api.course.entity.Course;
import com.galete.learnhub.api.course.mapper.CourseMapper;
import com.galete.learnhub.api.course.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @PostMapping
    public ResponseEntity<CourseResponse> create(@Valid @RequestBody CourseRequest courseRequest) {
        Course course = courseMapper.toEntity(courseRequest);

        course = courseService.create(course);

        CourseResponse courseResponse = courseMapper.toDTO(course);

        return new ResponseEntity<>(courseResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CourseResponse> findCourseById(@PathVariable Long id) {
        Course course = courseService.findById(id);

        CourseResponse courseResponse = courseMapper.toDTO(course);

        return new ResponseEntity<>(courseResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<CourseResponse>> findAllCourses(Pageable pageable) {
        Page<Course> coursePage = courseService.findAll(pageable);

        return new ResponseEntity<>(coursePage.map(courseMapper::toDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
