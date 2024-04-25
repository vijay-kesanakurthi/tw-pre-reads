package com.example.demo.services;


import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Util {

        public String generateUserId() {
            return UUID.randomUUID().toString().replace("-", "");
        }
}
