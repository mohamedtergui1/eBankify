package org.example.ebankify.controller;

import jakarta.validation.Valid;
import org.example.ebankify.entity.User;
import org.example.ebankify.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
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