package pl.sda.urbaniec.movie_mvc.web.controllers;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import pl.sda.urbaniec.movie_mvc.data.entity.Review;
import pl.sda.urbaniec.movie_mvc.web.services.ReviewsService;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ReviewControllerTest {
    public List<Review> createReview() {
        List<Review> mockList = new LinkedList<Review>();
        mockList.add(new Review(1L, "Review1", LocalDate.now()));
        mockList.add(new Review(2L, "Review2", LocalDate.now().plusDays(2)));
        mockList.add(new Review(3L, "Review3", LocalDate.now().plusDays(3)));
        return mockList;
    }

    public List<Review> createOneReview() {
        List<Review> mockList = new LinkedList<Review>();
        mockList.add(new Review(1L, "Review1", LocalDate.now()));
        return mockList;
    }

    @Test
    public void shouldShowReviews() throws Exception {
        ReviewsService revService = Mockito.mock(ReviewsService.class);
        ReviewController reviewControllerMock = new ReviewController(revService);
        MockMvc mockMvc = standaloneSetup(reviewControllerMock)
                .setSingleView(new InternalResourceView("/webapp/WEB-INF/jsp/reviews.jsp"))
                .build();

        Mockito.when(revService.findAllReviews()).thenReturn(createReview());

        mockMvc.perform(get("/reviews"))
                .andExpect(view().name("reviews"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("reviews"))
                .andExpect(model().attribute("reviews", revService.findAllReviews()))
                .andExpect(model().attribute("reviews", hasItems(createReview().toArray())));
    }

    @Test
    public void shouldShowCountedReviews() throws Exception {
        ReviewsService revService = Mockito.mock(ReviewsService.class);
        ReviewController reviewControllerMock = new ReviewController(revService);
        MockMvc mockMvc = standaloneSetup(reviewControllerMock)
                .setSingleView(new InternalResourceView("/webapp/WEB-INF/jsp/reviews.jsp"))
                .build();

        Mockito.when(revService.displayRequstedCount(Mockito.anyInt())).thenReturn(createOneReview());

        mockMvc.perform(get("/reviews?count=1"))
                .andExpect(view().name("reviews"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("reviews"))
                .andExpect(model().attribute("reviews", revService.displayRequstedCount(1)))
                .andExpect(model().attribute("reviews", hasItems(createOneReview().toArray())));
    }
}