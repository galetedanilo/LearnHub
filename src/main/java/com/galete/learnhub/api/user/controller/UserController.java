package com.galete.learnhub.api.user.controller;

import com.galete.learnhub.api.user.dto.request.UserCreateRequest;
import com.galete.learnhub.api.user.dto.request.UserRequest;
import com.galete.learnhub.api.user.dto.response.UserResponse;
import com.galete.learnhub.api.user.entity.User;
import com.galete.learnhub.api.user.mapper.UserMapper;
import com.galete.learnhub.api.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<String> createAccount(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        User user = userMapper.userCreateRequestToUser(userCreateRequest);

        userService.register(user);

        return new ResponseEntity<>("Your account has been created successfully", HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<UserResponse> update(@Valid @RequestBody UserRequest userRequest, @PathVariable Long id) {
        User user = userService.update(id, userRequest);

        UserResponse userResponse = userMapper.userToUserResponse(user);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id) {
        User user = userService.findById(id);

        UserResponse userResponse = userMapper.userToUserResponse(user);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
