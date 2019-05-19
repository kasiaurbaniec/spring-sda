package pl.sda.urbaniec.movie_mvc.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.urbaniec.movie_mvc.web.services.ReviewsService;

@Controller
@RequestMapping(value = {"/reviews"})
public class ReviewController {
    private final ReviewsService reviewsService;

    public ReviewController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    String reviews(Model model, @RequestParam(value = "count", defaultValue = "0") int count) {
        if (count > 0) {
            model.addAttribute("reviews", reviewsService.displayRequstedCount(count));
            return "reviews";
        } else {
            model.addAttribute("reviews", reviewsService.findAllReviews());
            return "reviews";
        }
    }
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    String review(Model model, @PathVariable Long id) throws Exception {
        model.addAttribute("review", reviewsService.findById(id));
        return "oneReview";

    }

}
