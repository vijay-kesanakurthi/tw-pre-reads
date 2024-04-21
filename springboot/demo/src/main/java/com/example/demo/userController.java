package com.example.demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class userController {

    @GetMapping
    public String getUser(){
        return "User";
    }

    @PostMapping
    public String setUser(){
        return "User was created";
    }

    @PutMapping
    public String updateUser(){
        return "User was updated";
    }

    @DeleteMapping
    public String deleteUser(){
        return "User was deleted";
    }
}
