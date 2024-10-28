package org.example.ebankify.service.auth;

import org.example.ebankify.dto.LoginDto;
import org.example.ebankify.entity.User;

public interface AuthService {
    User login(LoginDto loginDto);
    User register(User user);
}
