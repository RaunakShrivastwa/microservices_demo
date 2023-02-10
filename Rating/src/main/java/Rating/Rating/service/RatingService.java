package Rating.Rating.service;

import Rating.Rating.entity.Rating;

import java.util.List;

public interface RatingService {

//    creating the Rating
    Rating saveRating(Rating rating);

//    getAll Rating
    List<Rating> getAllRating();

//    get single Rating
    public Rating getSingleRating(int ratingId);

//    get SingleRating ByUserId
    List<Rating> getRatingByUserId(int userId);

//    get single Rating ByHotelId
    List<Rating> getRatingByHotelId(int hotelId);
}
