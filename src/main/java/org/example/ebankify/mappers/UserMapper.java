package org.example.ebankify.mappers;

import org.example.ebankify.dto.request.CreateUserRequest;
import org.example.ebankify.dto.request.LoginRequest;
import org.example.ebankify.dto.request.RegisterRequest;
import org.example.ebankify.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(CreateUserRequest createUserRequest);

    User toEntity(LoginRequest loginRequest);

    User toEntity(RegisterRequest registerRequest);

}