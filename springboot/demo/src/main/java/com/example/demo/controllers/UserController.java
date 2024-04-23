package com.example.demo.controllers;


import com.example.demo.models.UserDetailsRequestModel;
import com.example.demo.models.UserRest;
import com.example.demo.models.UserUpdateModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private Map<String,UserRest> users= new HashMap<>();

    @GetMapping
    public Map<String,UserRest> getUsers( @RequestParam(value="page",defaultValue = "1",required = false) int page, @RequestParam(value="limit",defaultValue = "1",required = false) int limit){
        return  users==null?null:users;
    }

    @GetMapping(path="/{userId}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        if( users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){

        UserRest user=new UserRest();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());

        if(users == null) users = new HashMap<>();
        String userId = UUID.randomUUID().toString().replace("-","");
        user.setUserId(userId);
        users.put(userId,user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId,@Valid @RequestBody UserUpdateModel userDetails){
        if(!users.containsKey(userId)) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        return new ResponseEntity<>(storedUserDetails, HttpStatus.OK);
    }

    @DeleteMapping
    public String deleteUser(){
        return "User was deleted";
    }
}
