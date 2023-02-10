package com.User.Extyernal;

import com.User.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "RATINGSERVICE")
public interface ServiceFignClient {

    @GetMapping("/rating/user/{id}")
    List<Rating> getRating(@PathVariable int id);

}
