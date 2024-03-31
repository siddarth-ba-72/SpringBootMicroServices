package com.microservices.user.service.UserService.Services;

import com.microservices.user.service.UserService.Models.User;

import java.util.List;

public interface UserService {

    // Create User
    User saveUser(User user);

    // Get All Users
    List<User> getAllUsers();

    // Get Single User of Given User ID
    User getUser(String userId);
}
