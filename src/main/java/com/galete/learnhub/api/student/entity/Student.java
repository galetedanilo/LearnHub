package com.galete.learnhub.api.student.entity;

import com.galete.learnhub.api.course.entity.Course;
import com.galete.learnhub.api.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean enabled;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @PrePersist
    private void prePersist() {
        var temp = LocalDateTime.now();
        this.createdAt =  temp;
        this.updatedAt = temp;
        this.enabled = false;
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
