package org.example.ebankify.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.ebankify.entity.User;
import org.example.ebankify.enums.UserRole;

@Getter
@Setter
public class CreateUserRequest extends RegisterRequest {
    @NotNull
    private UserRole role;

    public User toUser() {
        User user = super.toUser();
        user.setRole(role);
        return user;
    }
}
