package com.microservices.hotel.service.HotelService.Repositories;

import com.microservices.hotel.service.HotelService.Models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
