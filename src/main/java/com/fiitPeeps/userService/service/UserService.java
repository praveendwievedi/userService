package com.fiitPeeps.userService.service;

import com.fiitPeeps.userService.dto.RegisterRequest;
import com.fiitPeeps.userService.dto.UserResponse;
import com.fiitPeeps.userService.model.UserModel;
import com.fiitPeeps.userService.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repo;

    public UserResponse getUserProfileById(String userId) {
        UserModel user=repo.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
        UserResponse userResponse=new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setUserId(user.getUserId());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return  userResponse;
    }

    public UserResponse registerUser(@Valid RegisterRequest request) {
//        System.out.println(request.getEmail());
        if(repo.existsByEmail(request.getEmail())){
            throw  new RuntimeException("User already exists");
        }
        UserModel user=new UserModel();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        UserModel savedUser=repo.save(user);
        UserResponse userResponse=new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setUserId(user.getUserId());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return  userResponse;
    }

    public Boolean existUserById(String userId) {
        return repo.existsById(userId);
    }
}
