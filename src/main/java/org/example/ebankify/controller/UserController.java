package org.example.ebankify.controller;

import jakarta.validation.Valid;
import org.example.ebankify.entity.User;
import org.example.ebankify.dto.request.CreateUserRequest;
import org.example.ebankify.mappers.UserMapper;
import org.example.ebankify.service.user.UserService;
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
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody @Valid CreateUserRequest request) {
        return userService.saveUser(userMapper.toEntity(request));
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
    }
}