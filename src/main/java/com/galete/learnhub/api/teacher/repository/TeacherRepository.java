package com.galete.learnhub.api.teacher.repository;

import com.galete.learnhub.api.teacher.entity.Teacher;
import com.galete.learnhub.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<User> findByUserId(Long id);
}
