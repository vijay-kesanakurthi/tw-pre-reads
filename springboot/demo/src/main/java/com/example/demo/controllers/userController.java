package com.example.demo.controllers;


import com.example.demo.models.userRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class userController {

    @GetMapping
    public String getUsers( @RequestParam(value="page") int page, @RequestParam(value="limit",defaultValue = "1",required = false) int limit){
        return "page is: " + page + " and the limit is: "+ limit;
    }

    @GetMapping(path="/{userId}")
    public userRest getUser(@PathVariable String userId){

        return new userRest("John", "Doe", "JhonDoe@gmail.com", userId);
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
