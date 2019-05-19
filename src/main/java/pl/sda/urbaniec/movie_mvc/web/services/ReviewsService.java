package pl.sda.urbaniec.movie_mvc.web.services;

import org.springframework.stereotype.Service;
import pl.sda.urbaniec.movie_mvc.data.entity.Review;
import pl.sda.urbaniec.movie_mvc.data.repository.ReviewRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReviewsService {
    private final ReviewRepository reviewRepository;

    public ReviewsService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAllReviews() {
        List<Review> collect = StreamSupport.stream(reviewRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return collect;
    }

    public List<Review> displayRequstedCount(int count) {
        List<Review> collect = StreamSupport.stream(reviewRepository.findAll().spliterator(), false).limit(count).collect(Collectors.toList());
        return collect;
    }

    public Review findById(Long id) throws Exception {
            return reviewRepository.findById(id).orElseThrow(Exception::new);
    }
}
