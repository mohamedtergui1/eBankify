package org.example.ebankify.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Getter
@Setter
@Builder
public class LoginDto {
    @NotBlank(message = "email is require")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "password is require")
    private String password;
}
