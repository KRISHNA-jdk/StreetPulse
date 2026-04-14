package StreetPulse.StreetPulse.services;


import StreetPulse.StreetPulse.dto.BusinessRequest;
import StreetPulse.StreetPulse.entity.Business;
import StreetPulse.StreetPulse.entity.User;
import StreetPulse.StreetPulse.repository.BusinessRepository;
import StreetPulse.StreetPulse.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;

    public BusinessService(BusinessRepository businessRepository,
                           UserRepository userRepository){
        this.businessRepository = businessRepository;
        this.userRepository = userRepository;
    }

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

    public List<Business> getAllBusiness(){
        return businessRepository.findAll();
    }

    public Business getBusinessById(long id){
        return businessRepository.findById(id).orElseThrow(()-> new RuntimeException("BUSINESS NOT FOUND"));
    }
}
