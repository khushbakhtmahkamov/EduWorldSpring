import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating updateRating(Long id, Rating updatedRating) {
        Optional<Rating> optional = ratingRepository.findById(id);
        if (optional.isPresent()) {
            Rating rating = optional.get();
            rating.setUserId(updatedRating.getUserId());
            rating.setGrade(updatedRating.getGrade());
            rating.setProgressId(updatedRating.getProgressId());
            return ratingRepository.save(rating);
        }
        return null;
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}


