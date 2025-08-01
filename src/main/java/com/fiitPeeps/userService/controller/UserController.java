package com.fiitPeeps.userService.controller;

import com.fiitPeeps.userService.dto.RegisterRequest;
import com.fiitPeeps.userService.dto.UserResponse;
import com.fiitPeeps.userService.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUseProfile(@PathVariable String userId){
     return ResponseEntity.ok(userService.getUserProfileById(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterRequest request){
        return  ResponseEntity.ok(userService.registerUser(request));
    }

    @GetMapping("/{userId}/validate")
    public  ResponseEntity<Boolean> validateUserById(@PathVariable String userId){
        return ResponseEntity.ok(userService.existUserById(userId));
    }

    @GetMapping("/test")
    public  String testConnection(){
        return "we are live";
    }
}
