package Rating.Rating.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private int userId;
  private int hotelId;
  private int rating;
  private String feedback;
}
