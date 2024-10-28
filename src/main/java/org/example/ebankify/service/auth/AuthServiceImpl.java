package org.example.ebankify.service.auth;

import org.example.ebankify.dto.LoginDto;
import org.example.ebankify.entity.User;
import org.example.ebankify.enums.UserRole;
import org.example.ebankify.repository.UserRepository;
import org.example.ebankify.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User login(LoginDto loginDto) {
        userRepository.findByEmail(loginDto.getEmail()).ifPresent(user -> {

        });
        return null;
    }

    @Override
    public User register(User user) {
        user.setRole(UserRole.USER);
        return null;
    }
}
