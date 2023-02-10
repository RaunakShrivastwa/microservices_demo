package Rating.Rating.reprositery;

import Rating.Rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingReprositery extends JpaRepository<Rating,Integer> {
    List<Rating> findByUserId(int userId);

    List<Rating> findByHotelId(int hotelId);
}
