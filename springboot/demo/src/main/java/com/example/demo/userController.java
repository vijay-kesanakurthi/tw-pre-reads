package com.example.demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class userController {

    @GetMapping(path="/{userId}")
    public String getUser(@PathVariable String userId){
        return "The user id is: " + userId;
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
