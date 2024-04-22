package com.example.demo.controllers;


import com.example.demo.models.UserDetailsRequestModel;
import com.example.demo.models.UserRest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping
    public String getUsers( @RequestParam(value="page") int page, @RequestParam(value="limit",defaultValue = "1",required = false) int limit){
        return "page is: " + page + " and the limit is: "+ limit;
    }

    @GetMapping(path="/{userId}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest user = new UserRest();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("jhondoe@gmail.com");
        user.setUserId(userId);

        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){



        UserDetailsRequestModel userDetailsRequestModel = new UserDetailsRequestModel();
        userDetailsRequestModel.setFirstName(userDetails.getFirstName());
        userDetailsRequestModel.setLastName(userDetails.getLastName());
        userDetailsRequestModel.setEmail(userDetails.getEmail());
        userDetailsRequestModel.setPassword(userDetails.getPassword());

        return new ResponseEntity<String>("User was created", HttpStatus.OK);
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
