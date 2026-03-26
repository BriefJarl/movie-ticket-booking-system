package com.bhumi.moviebooking.service;

import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    public String loginUser(String username) {
        return "User " + username + " logged in successfully";
    }

    public String logoutUser(String username) {
        return "User " + username + " logged out successfully";
    }
}