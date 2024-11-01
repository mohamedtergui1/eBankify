package org.example.ebankify.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.ebankify.entity.User;
import org.example.ebankify.enums.UserRole;

@Getter
public class CreateUserRequest extends RegisterRequest {
    @NotNull
    private UserRole role;

}
