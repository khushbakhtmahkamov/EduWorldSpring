import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    Rating getRatingById(Long id);

    List<Rating> getAllRatings();

    Rating updateRating(Long id, Rating rating);

    void deleteRating(Long id);
}
