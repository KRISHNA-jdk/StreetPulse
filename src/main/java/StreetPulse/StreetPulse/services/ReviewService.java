package StreetPulse.StreetPulse.services;

import StreetPulse.StreetPulse.dto.ReviewRequest;
import StreetPulse.StreetPulse.entity.Business;
import StreetPulse.StreetPulse.entity.Review;
import StreetPulse.StreetPulse.entity.User;
import StreetPulse.StreetPulse.repository.BusinessRepository;
import StreetPulse.StreetPulse.repository.ReviewRepository;
import StreetPulse.StreetPulse.repository.UserRepository;
import jakarta.validation.constraints.Email;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    private final UserRepository userRepository;
    private final BusinessRepository businessRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(UserRepository userRepository,
                         BusinessRepository businessRepository,
                         ReviewRepository reviewRepository){
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(ReviewRequest request){

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("USER NOT FOUND"));

        Business business = businessRepository.findById(request.getBusinessId()).orElseThrow(
                ()-> new RuntimeException("BUSINESS NOT FOUND")
        );

        Review review = new Review();

        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setUser(user);
        review.setBusiness(business);
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());

        return reviewRepository.save(review);


    }

    public List<Review> getReviewsByBusiness(Long BusinessId){
        return reviewRepository.findByBusinessId(BusinessId);
    }

    public double getAverageRating(Long businessId){

        List <Review> reviews = reviewRepository.findByBusinessId(businessId);

        if(reviews.isEmpty()){
            return 0;
        }

        double sum = 0;

        for(Review r : reviews){
           sum = sum + r.getRating();
        }
        return sum / reviews.size();
    }
}
