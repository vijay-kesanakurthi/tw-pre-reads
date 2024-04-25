package com.example.demo.controllers;

import com.example.demo.models.UserDetailsRequestModel;
import com.example.demo.models.UserRest;
import com.example.demo.models.UserUpdateModel;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public Map<String,UserRest> getUsers( @RequestParam(value="page",defaultValue = "1",required = false) int page, @RequestParam(value="limit",defaultValue = "1",required = false) int limit){
        return  userService.getUsers();
    }

    @GetMapping(path="/{userId}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest user= userService.getUser(userId);
        if(user==null) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
        UserRest user=userService.createUser(userDetails);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId,@Valid @RequestBody UserUpdateModel userDetails){
        UserRest updateUser= userService.updateUser(userId,userDetails);
        if(updateUser==null) return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
           userService.deleteUser(userId);
        return  ResponseEntity.noContent().build();
    }
}
