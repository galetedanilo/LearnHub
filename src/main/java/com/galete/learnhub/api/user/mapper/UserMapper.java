package com.galete.learnhub.api.user.mapper;

import com.galete.learnhub.api.user.dto.request.UserCreateRequest;
import com.galete.learnhub.api.user.dto.request.UserRequest;
import com.galete.learnhub.api.user.dto.response.UserResponse;
import com.galete.learnhub.api.user.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User userCreateRequestToUser(UserCreateRequest userCreateRequest);

    UserResponse userToUserResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserRequestToUser(UserRequest userRequest, @MappingTarget User user);

}
