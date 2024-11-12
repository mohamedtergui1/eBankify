package org.example.ebankify.controller;

import jakarta.validation.Valid;
import org.example.ebankify.dto.request.user.LoginRequest;
import org.example.ebankify.dto.request.user.RegisterRequest;
import org.example.ebankify.entity.User;
import org.example.ebankify.mappers.UserMapper;
import org.example.ebankify.service.auth.AuthService;
import org.example.ebankify.util.Jwt;
import org.example.ebankify.util.ResponseForme;
import org.example.ebankify.util.ResponseFormeWithToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final Jwt jwtUtil;
    private final UserMapper userMapper;

    @Autowired
    public AuthController(AuthService authService, Jwt jwtUtil, UserMapper userMapper) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseForme<ResponseFormeWithToken<User>>> login(@RequestBody @Valid LoginRequest loginRequest) {
        User user = authService.login(userMapper.toEntity(loginRequest));
        return ResponseEntity.ok(
                new ResponseFormeWithToken<User>(
                        jwtUtil.generateToken(
                                user.getEmail() + "<@>" + user.getRole().name()), user, "login with success"));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseForme<User>> register(@RequestBody @Valid RegisterRequest registerRequest) {
        return ResponseEntity.status(201).body(
                new ResponseForme<User>(
                        authService.register(
                                userMapper.toEntity(registerRequest)), "register with success"));
    }

}