package com.microservices.user.service.UserService;

import com.microservices.user.service.UserService.Externals.Services.RatingService;
import com.microservices.user.service.UserService.Models.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void createRating() {
//		Rating rating = Rating.builder()
//						.rating(10)
//						.userId("")
//						.hotelId("")
//						.feedback("Created using feign client")
//						.build();
//
//		Rating savedRating = ratingService.createRating(rating);
//		System.out.println("New Rating Created!");
//	}

}
