package com.fiitPeeps.userService.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalTime;

@Data
public class UserResponse {
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private LocalTime createdAt;
    private LocalTime updatedAt;
}
