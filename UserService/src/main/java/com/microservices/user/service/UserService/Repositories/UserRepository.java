package com.microservices.user.service.UserService.Repositories;

import com.microservices.user.service.UserService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
