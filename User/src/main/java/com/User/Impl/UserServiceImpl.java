package com.User.Impl;


import com.User.Extyernal.ServiceFignClient;
import com.User.entity.Hotel;
import com.User.entity.Rating;
import com.User.entity.User;
import com.User.repositery.UserRepositery;
import com.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositery userRepositery;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ServiceFignClient serviceFignClient;

    @Override
    public User saveUSer(User user) {
        return this.userRepositery.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepositery.findAll();
    }

    @Override
    public User getSingleUser(int id) {
        User user = this.userRepositery.findById(id).get();
//        using feignClient
        List<Rating> ratings = serviceFignClient.getRating(user.getId());
//        Rating[] forObject = restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+user.getId(), Rating[].class);
//        List<Rating> ratings = Arrays.stream(forObject).toList();
        ratings.stream().map(rating -> {
            System.out.println("rating :- "+rating);
            Hotel hotel = restTemplate.getForObject("http://HOTELSERVICE/hotel/"+rating.getHotelId(), Hotel.class);
            System.out.println("hotel = " + hotel);
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRating(ratings);
        return user;
    }
}
