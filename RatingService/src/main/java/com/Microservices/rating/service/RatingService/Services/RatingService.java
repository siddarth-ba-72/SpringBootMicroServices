package com.Microservices.rating.service.RatingService.Services;

import com.Microservices.rating.service.RatingService.Models.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    // Create Rating
    Rating create(Rating rating);

    // Get all Ratings
    List<Rating> getRatings();

    // Get All Ratings by User Id
    List<Rating> getRatingByUserId(String userId);

    // Get All Ratings by Hotel Id
    List<Rating> getRatingByHotelId(String HotelId);
}
