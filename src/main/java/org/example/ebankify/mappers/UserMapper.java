package org.example.ebankify.mappers;

import org.example.ebankify.dto.request.user.CreateUserRequest;
import org.example.ebankify.dto.request.user.LoginRequest;
import org.example.ebankify.dto.request.user.RegisterRequest;
import org.example.ebankify.dto.request.user.UpdateUserRequest;
import org.example.ebankify.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(CreateUserRequest createUserRequest);

    User toEntity(LoginRequest loginRequest);

    User toEntity(RegisterRequest registerRequest);

    User toEntity(UpdateUserRequest updateUserRequest);

}