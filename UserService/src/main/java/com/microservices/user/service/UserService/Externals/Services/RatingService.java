package com.microservices.user.service.UserService.Externals.Services;

import com.microservices.user.service.UserService.Models.Rating;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
