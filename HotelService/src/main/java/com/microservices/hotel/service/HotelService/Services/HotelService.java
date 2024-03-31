package com.microservices.hotel.service.HotelService.Services;

import com.microservices.hotel.service.HotelService.Models.Hotel;

import java.util.List;

public interface HotelService {

    // Create Hotel
    Hotel create(Hotel hotel);

    // Get all Hotels
    List<Hotel> getAll();

    // Get Hotel Details
    Hotel get(String id);
}
