package com.User.controller;

import com.User.entity.User;
import com.User.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private Logger logger= LoggerFactory.getLogger(UserController.class);

//    for the creation of User
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUSer(user));
    }

//    for the getAll User
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(this.userService.getAllUser());
    }

//    getSingle User

    @GetMapping("/{id}")
    @CircuitBreaker(name="RatingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable int id){
        return ResponseEntity.ok().body(this.userService.getSingleUser(id));
    }

    public ResponseEntity<User> ratingHotelFallback(int id,Exception ex){
        logger.info("inside fallbackMethod");
        User user=User.builder()
                .id(120)
                .userEmail("dummy@gmail.com")
                .userName("Dummy User Created Because Service is Down:- ")
                .build();
        return ResponseEntity.ok().body(user);
    }

}
