package com.example.demo.services;


import com.example.demo.models.UserDetailsRequestModel;
import com.example.demo.models.UserRest;
import com.example.demo.models.UserUpdateModel;

import java.util.Map;

public  interface UserService {
    Map<String ,UserRest> getUsers();
    UserRest createUser(UserDetailsRequestModel userDetails);
    UserRest getUser(String userId);
    UserRest updateUser(String userId, UserUpdateModel userDetails);
    void deleteUser(String userId);

}
