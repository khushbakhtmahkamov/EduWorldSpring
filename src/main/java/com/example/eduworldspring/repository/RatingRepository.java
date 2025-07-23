import org.springframework.data.jpa.repository.JpaRepository;
import com.example.eduworldspring.model.Rating;


public interface RatingRepository extends JpaRepository<Rating, Long> {
}
