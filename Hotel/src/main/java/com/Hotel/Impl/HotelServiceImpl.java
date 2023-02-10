package com.Hotel.Impl;

import com.Hotel.entity.Hotel;
import com.Hotel.repositery.HotelReprositery;
import com.Hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelReprositery hotelReprositery;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return this.hotelReprositery.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return this.hotelReprositery.findAll();
    }

    @Override
    public Hotel singleHotel(int hotelId) {
        return this.hotelReprositery.findById(hotelId).get();
    }
}
