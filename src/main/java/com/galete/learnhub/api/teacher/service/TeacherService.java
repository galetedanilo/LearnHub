package com.galete.learnhub.api.teacher.service;

import com.galete.learnhub.api.teacher.entity.Teacher;
import com.galete.learnhub.api.teacher.repository.TeacherRepository;
import com.galete.learnhub.api.user.entity.User;
import com.galete.learnhub.exception.ResourceNotFound;
import com.galete.learnhub.exception.UniqueUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public Teacher create(Teacher teacher) {
        validateUserUniqueness(teacher.getUser());
        return teacherRepository.save(teacher);
    }

    private void validateUserUniqueness(User user) {
        teacherRepository.findByUserId(user.getId()).ifPresent(student -> new UniqueUser("There is a registered user with this data"));
    }

    public Teacher findById(Long id) {
        return this.teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Teacher with id: " + id + " is not found"));
    }

    public Page<Teacher> findAll(Pageable pageable) {
        return this.teacherRepository.findAll(pageable);
    }

    public Teacher update(Long id, Teacher teacher) {
        findById(id);

        return teacherRepository.save(teacher);
    }

    public void remove(Long id) {
        findById(id);

        teacherRepository.deleteById(id);
    }
}
