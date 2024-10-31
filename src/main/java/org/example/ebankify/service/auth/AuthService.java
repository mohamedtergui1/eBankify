package org.example.ebankify.service.auth;

import org.example.ebankify.request.LoginRequest;
import org.example.ebankify.entity.User;

public interface AuthService {
    User login(LoginRequest loginRequest);
    User register(User user);
}
