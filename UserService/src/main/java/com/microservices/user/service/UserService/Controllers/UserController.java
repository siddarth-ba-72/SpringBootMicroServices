package com.microservices.user.service.UserService.Controllers;

import com.microservices.user.service.UserService.Models.User;
import com.microservices.user.service.UserService.Services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // get single user
    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // creating fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception exception) {
        User user = User.builder()
                .userId("124585")
                .email("dummy@name.com")
                .name("Dummy")
                .about("Manager")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
