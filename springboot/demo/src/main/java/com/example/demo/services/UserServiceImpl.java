package com.example.demo.services;


import com.example.demo.models.UserDetailsRequestModel;
import com.example.demo.models.UserRest;
import com.example.demo.models.UserUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

     Map<String, UserRest> users;

     Util util;

     public UserServiceImpl() {
     }
     @Autowired
     public UserServiceImpl(Util util) {
        this.util = util;
     }

     @Override
     public Map<String,UserRest> getUsers() {
         return users;
     }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = util.generateUserId();
        returnValue.setUserId(userId);

        if(users == null) users = new HashMap<>();
        users.put(userId, returnValue);
        return returnValue;
    }

    @Override
    public UserRest getUser(String userId) {
        if(users == null || hasNoUser(userId)) return null;
        return users.get(userId);
    }

    @Override
    public UserRest updateUser(String userId, UserUpdateModel userDetails) {
        if(users == null || hasNoUser(userId)) return null;

        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @Override
    public void deleteUser(String userId) {
        if(users == null || hasNoUser(userId)) return ;
        users.remove(userId);
    }




    private boolean hasNoUser(String userId){
        return !users.containsKey(userId);
    }
}
