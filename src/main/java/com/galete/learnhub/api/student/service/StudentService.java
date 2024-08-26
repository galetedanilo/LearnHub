package com.galete.learnhub.api.student.service;

import com.galete.learnhub.api.student.entity.Student;
import com.galete.learnhub.api.student.repository.StudentRepository;
import com.galete.learnhub.api.user.entity.User;
import com.galete.learnhub.exception.ResourceNotFound;
import com.galete.learnhub.exception.UniqueUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student create(Student student) {
        validateUserUniqueness(student.getUser());
        return studentRepository.save(student);
    }

    private void validateUserUniqueness(User user) {
         studentRepository.findByUserId(user.getId()).ifPresent(student -> new UniqueUser("There is a registered user with this data"));
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Student with id: " + id + " is not found"));
    }

    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student update(Long id, Student student) {
        findById(id);

        return studentRepository.save(student);
    }

    public void remove(Long id) {
        findById(id);

        studentRepository.deleteById(id);
    }

}
