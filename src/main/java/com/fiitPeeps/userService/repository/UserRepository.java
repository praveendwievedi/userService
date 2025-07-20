package com.fiitPeeps.userService.repository;

import com.fiitPeeps.userService.model.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    boolean existsByEmail(String email);
}
