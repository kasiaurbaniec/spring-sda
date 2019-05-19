package pl.sda.urbaniec.movie_mvc.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.urbaniec.movie_mvc.data.entity.Review;
import pl.sda.urbaniec.movie_mvc.data.repository.ReviewRepository;

import java.time.LocalDate;
@Configuration
@Slf4j
public class LoadDataBase {
    @Bean
    CommandLineRunner initDataBase(ReviewRepository reviews) {
        return args -> {
            log.info("inserting to database " +reviews.save(new Review(1L,"First Review",LocalDate.of(2019,5,01))));
            log.info("inserting to database " +reviews.save(new Review( 2L,"Second Review",LocalDate.of(2019,6,15))));
            log.info("inserting to database " +reviews.save(new Review(3L,"Third Review",LocalDate.of(2019,1,30))));

        };
    }
}
