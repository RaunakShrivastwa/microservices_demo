package com.Hotel.service;

import com.Hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

//    creating hotel
    Hotel saveHotel(Hotel hotel);

//    get All Hotel
    List<Hotel> getAllHotel();

//    get single Hotel
    Hotel singleHotel(int hotelId);
}
