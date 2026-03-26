package com.bhumi.moviebooking.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String createUser() {
        return "User created successfully";
    }

    public String getAllUsers() {
        return "All users fetched successfully";
    }

    public String deleteUser(Long id) {
        return "User with id " + id + " deleted successfully";
    }
}