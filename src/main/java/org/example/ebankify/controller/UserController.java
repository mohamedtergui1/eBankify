package org.example.ebankify.controller;

import jakarta.validation.Valid;
import org.example.ebankify.dto.request.user.UpdateUserRequest;
import org.example.ebankify.entity.Loan;
import org.example.ebankify.entity.User;
import org.example.ebankify.dto.request.user.CreateUserRequest;
import org.example.ebankify.mappers.UserMapper;
import org.example.ebankify.service.user.UserService;
import org.example.ebankify.util.ResponseForme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService , UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public ResponseForme<User> getUser(@PathVariable Long id) {
        return new ResponseForme<>(userService.getUserById(id));
    }

    @PostMapping
    public ResponseForme<User> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return new ResponseForme<>(userService.saveUser(userMapper.toEntity(createUserRequest)), "user created successfully");
    }

    @PutMapping
    public ResponseForme<User> updateUser(@RequestBody @Valid UpdateUserRequest updateUserRequest) {
        return new ResponseForme<>(userService.updateUser(userMapper.toEntity(updateUserRequest)), "user updated successfully");
    }

    @DeleteMapping
    public ResponseForme<?> deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return new ResponseForme<>("User deleted successfully");
    }

}