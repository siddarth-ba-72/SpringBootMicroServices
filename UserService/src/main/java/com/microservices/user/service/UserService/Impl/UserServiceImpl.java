package com.microservices.user.service.UserService.Impl;

import com.microservices.user.service.UserService.Exceptions.ResourceNotFoundException;
import com.microservices.user.service.UserService.Externals.Services.HotelService;
import com.microservices.user.service.UserService.Models.Hotel;
import com.microservices.user.service.UserService.Models.Rating;
import com.microservices.user.service.UserService.Models.User;
import com.microservices.user.service.UserService.Repositories.UserRepository;
import com.microservices.user.service.UserService.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id not found on server"));
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{}", ratingsOfUser);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);

            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            logger.info("Response status code: {}", forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).toList();
        user.setRatings(ratingList);
        return user;
    }
}
