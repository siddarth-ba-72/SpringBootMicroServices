package com.microservices.user.service.UserService.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private String hotelId;
    private String name;
    private String location;
    private String about;
}
