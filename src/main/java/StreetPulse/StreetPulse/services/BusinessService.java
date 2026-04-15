package StreetPulse.StreetPulse.services;


import StreetPulse.StreetPulse.dto.BusinessRequest;
import StreetPulse.StreetPulse.dto.BusinessResponse;
import StreetPulse.StreetPulse.dto.ReviewRequest;
import StreetPulse.StreetPulse.entity.Business;
import StreetPulse.StreetPulse.entity.User;
import StreetPulse.StreetPulse.repository.BusinessRepository;
import StreetPulse.StreetPulse.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;
    private final ReviewService reviewService;

    public BusinessService(BusinessRepository businessRepository,
                           UserRepository userRepository,
                           ReviewService reviewService){
        this.businessRepository = businessRepository;
        this.userRepository = userRepository;
        this.reviewService = reviewService;
    }

//    int count = 0;

    public Business createBusiness(BusinessRequest request){

        //User owner = userRepository.findById(1L).orElseThrow(()-> new RuntimeException("OWNER NOT FOUND"));

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User owner = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("USER NOT FOUND"));

        Business business = new Business();

        business.setName(request.getName());
        business.setCategory(request.getCategory());
        business.setLocation(request.getLocation());
        business.setOwner(owner);
        business.setCreatedAt(LocalDateTime.now());
        business.setUpdatedAt(LocalDateTime.now());

        return businessRepository.save(business);
    }

    public List<BusinessResponse> getAllBusiness(){
        List <Business> businesses = businessRepository.findAll();

        return businesses.stream()
                .map(b -> new BusinessResponse(
                        b.getId(),
                        b.getName(),
                        b.getCategory(),
                        b.getLocation(),
                        b.getViewCount(),
                        reviewService.getAverageRating(b.getId())
                ))
                .collect(Collectors.toList());
    }

    public BusinessResponse getBusinessById(long id){

        Business business = businessRepository.findById(id).orElseThrow(()->
                new RuntimeException("BUSINESS NOT FOUND")
        );

        business.setViewCount(business.getViewCount() + 1);
        businessRepository.save(business);

//        return businessRepository.findById(id).orElseThrow(()-> new RuntimeException("BUSINESS NOT FOUND"));
        return new BusinessResponse(
                business.getId(),
                business.getName(),
                business.getCategory(),
                business.getLocation(),
                business.getViewCount(),
                reviewService.getAverageRating(business.getId())
        );

    }

    public List <BusinessResponse> getTrendingBusiness (){

        List <Business> businesses = businessRepository.findAll();

        return businesses.stream()
                .sorted((b1, b2) -> {
            double score1 = b1.getViewCount() +
                    (reviewService.getAverageRating(b1.getId())*10);

            double score2 = b2.getViewCount() +
                    (reviewService.getAverageRating(b2.getId())*10);

            return Double.compare(score2, score1);
        })
                .map(b -> new BusinessResponse(
                b.getId(),
                b.getName(),
                b.getCategory(),
                b.getLocation(),
                b.getViewCount(),
                reviewService.getAverageRating(b.getId())
        )).collect(Collectors.toList());
    }

    public List <BusinessResponse> getMyBusiness(){

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findByEmail(email).
                orElseThrow(()-> new RuntimeException("USER NOT FOUND"));

//        return businessRepository.findByOwnerId(user.getId());

        List <Business> businesses = businessRepository.findByOwnerId(user.getId());

        return businesses.stream()
                .map(b -> new BusinessResponse(
                        b.getId(),
                        b.getName(),
                        b.getCategory(),
                        b.getLocation(),
                        b.getViewCount(),
                        reviewService.getAverageRating(b.getId())
                ))
                .collect(Collectors.toList());


    }

}
