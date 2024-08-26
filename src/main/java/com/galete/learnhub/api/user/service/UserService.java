package com.galete.learnhub.api.user.service;

import com.galete.learnhub.api.user.dto.request.UserRequest;
import com.galete.learnhub.api.user.entity.User;
import com.galete.learnhub.api.user.mapper.UserMapper;
import com.galete.learnhub.api.user.repository.UserRepository;
import com.galete.learnhub.exception.ResourceNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void create(User user) {
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User with id: " + id + " is not found"));
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User update(Long id, UserRequest userRequest) {
        User user = findById(id);

        userMapper.updateUserRequestToUser(userRequest, user);

        return userRepository.save(user);
    }

    public void delete(Long id) {
        findById(id);

        userRepository.deleteById(id);
    }
}
