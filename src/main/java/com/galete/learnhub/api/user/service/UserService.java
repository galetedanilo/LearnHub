package com.galete.learnhub.api.user.service;

import com.galete.learnhub.api.user.dto.request.UserRequest;
import com.galete.learnhub.api.user.entity.User;
import com.galete.learnhub.api.user.mapper.UserMapper;
import com.galete.learnhub.api.user.resource.UserResource;
import com.galete.learnhub.exception.ResourceNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserResource userResource;
    private final UserMapper userMapper;

    public void register(User user) {

        userResource.save(user);

    }

    public User findById(Long id) {
        return userResource.findById(id).orElseThrow(() -> new ResourceNotFound("User with id: " + id + " is not found"));
    }

    public User update(Long id, UserRequest userRequest) {
        User user = findById(id);

        userMapper.updateUserRequestToUser(userRequest, user);

        return userResource.save(user);
    }

    public void delete(Long id) {
        findById(id);

        userResource.deleteById(id);
    }
}
