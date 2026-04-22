package StreetPulse.StreetPulse.controllers;


import StreetPulse.StreetPulse.dto.ReviewRequest;
import StreetPulse.StreetPulse.entity.Review;
import StreetPulse.StreetPulse.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review createReview(@RequestBody ReviewRequest request) {
        return reviewService.createReview(request);
    }

    @GetMapping("/business/{businessId}")
    public List<Review> getReviewsByBusiness(@PathVariable Long businessId) {
        return reviewService.getReviewsByBusiness(businessId);
    }

    @GetMapping("/business/{businessId}/average")
        public double getAverageRating(@PathVariable Long businessId){
            return reviewService.getAverageRating(businessId);
        }
}
