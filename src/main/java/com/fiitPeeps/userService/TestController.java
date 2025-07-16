package com.fiitPeeps.userService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public  String testConnection(){
        return "we are live";
    }
}
