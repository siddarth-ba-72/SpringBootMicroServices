package com.microservices.hotel.service.HotelService.Impl;

import com.microservices.hotel.service.HotelService.Exceptions.ResourceNotFoundException;
import com.microservices.hotel.service.HotelService.Models.Hotel;
import com.microservices.hotel.service.HotelService.Repositories.HotelRepository;
import com.microservices.hotel.service.HotelService.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id not found"));
    }
}
