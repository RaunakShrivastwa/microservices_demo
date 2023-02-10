package Rating.Rating.controller;

import Rating.Rating.entity.Rating;
import Rating.Rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
         return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingService.saveRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.ok().body(this.ratingService.getAllRating());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Rating> getSingleRating(@PathVariable int id){
        return ResponseEntity.ok().body(this.ratingService.getSingleRating(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable int userId){
        return ResponseEntity.ok().body(this.ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable int hotelId){
        return ResponseEntity.ok().body(this.ratingService.getRatingByHotelId(hotelId));
    }
}
