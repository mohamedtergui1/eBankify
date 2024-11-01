package org.example.ebankify.dto.request;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.example.ebankify.annotation.UniqueField;
import org.example.ebankify.entity.User;

@Getter
public class RegisterRequest {
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 30, message = "the length of password must be between 8 and 30")
    private String password;

    @NotBlank(message = "First name is required")
    @Size(min = 8, max = 30, message = "the length of first name must be between 8 and 30")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 8, max = 30, message = "the length of last name must be between 8 and 30")
    private String lastName;

    @UniqueField(entity = User.class, field = "email", message = "Email must be unique")
    @NotBlank(message = "Email is required")
    private String email;

}