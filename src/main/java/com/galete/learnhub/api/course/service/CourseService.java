package com.galete.learnhub.api.course.service;

import com.galete.learnhub.api.course.entity.Course;
import com.galete.learnhub.api.course.repository.CourseRepository;
import com.galete.learnhub.exception.ResourceNotFound;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Course create(Course course) {
        return courseRepository.save(course);
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Course with id: " + id + " is not found"));
    }

    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Transactional
    public Course update(Long id, Course course) {
        findById(id);

        course.setId(id);

        return courseRepository.save(course);
    }

    public void delete(Long id) {
        findById(id);

        courseRepository.deleteById(id);
    }

}
