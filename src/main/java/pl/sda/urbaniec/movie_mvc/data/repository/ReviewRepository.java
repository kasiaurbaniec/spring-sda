package pl.sda.urbaniec.movie_mvc.data.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.urbaniec.movie_mvc.data.entity.Review;

public interface ReviewRepository extends CrudRepository<Review,Long> {

}
