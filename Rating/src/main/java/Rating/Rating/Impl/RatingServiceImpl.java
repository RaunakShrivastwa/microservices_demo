package Rating.Rating.Impl;

import Rating.Rating.entity.Rating;
import Rating.Rating.reprositery.RatingReprositery;
import Rating.Rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingReprositery ratingReprositery;

    @Override
    public Rating saveRating(Rating rating) {
        return this.ratingReprositery.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return this.ratingReprositery.findAll();
    }

    @Override
    public Rating getSingleRating(int ratingId) {
        return this.ratingReprositery.findById(ratingId).get();
    }


    @Override
    public List<Rating> getRatingByUserId(int userId) {
        return this.ratingReprositery.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(int hotelId) {
        return this.ratingReprositery.findByHotelId(hotelId);
    }
}
