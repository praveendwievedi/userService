package com.fiitPeeps.userService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "email is required")
    @Email(message = "invalid email format")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8 , message = "password needs to be minimum 8 charcaters")
    private String password;
    private String keycloakId;
    private String firstName;
    private String lastName;
}
