package com.Microservices.rating.service.RatingService.Repositories;

import com.Microservices.rating.service.RatingService.Models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
