package com.galete.learnhub.api.user.resource;

import com.galete.learnhub.api.user.entity.User;
import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Resource
public interface UserResource extends JpaRepository<User, Long> {
}
