package com.galete.learnhub.api.user.mapper;

import com.galete.learnhub.api.user.dto.request.UserCreateRequest;
import com.galete.learnhub.api.user.dto.request.UserRequest;
import com.galete.learnhub.api.user.dto.response.UserResponse;
import com.galete.learnhub.api.user.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "picture",  ignore = true)
    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "enabled",  ignore = true)
    @Mapping(target = "createdAt",  ignore = true)
    User userRequestToUser(UserRequest userRequest);

    User userCreateRequestToUser(UserCreateRequest userCreateRequest);

    UserResponse userToUserResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserRequestToUser(UserRequest userRequest, @MappingTarget User user);

}
