import org.springframework.stereotype.Component;

@Component
public class RatingMapper {

    public Rating toRating(RatingCreateDto dto, Long id, User user, Progress progress) {
        return new Rating(
                id,
                user,
                dto.getGrade(),
                progress
        );
    }
}
