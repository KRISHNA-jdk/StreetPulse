package StreetPulse.StreetPulse.controllers;


import StreetPulse.StreetPulse.dto.BusinessRequest;
import StreetPulse.StreetPulse.dto.BusinessResponse;
import StreetPulse.StreetPulse.entity.Business;
import StreetPulse.StreetPulse.repository.BusinessRepository;
import StreetPulse.StreetPulse.services.BusinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/business")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService){
        this.businessService = businessService;
    }

    @PostMapping
    public Business createBusiness(@RequestBody BusinessRequest request){
        System.out.println("🔥 HIT CONTROLLER");
        return businessService.createBusiness(request);
    }

    @GetMapping
    public List<BusinessResponse> getAllBusiness(){
        return businessService.getAllBusiness();
    }

    @GetMapping("/{id}")
    public BusinessResponse getBusinessById(@PathVariable long id){
        return businessService.getBusinessById(id);
    }

    @GetMapping("/trending")
    public List <BusinessResponse> getTrendingBusinesses(){
        return businessService.getTrendingBusiness();
    }

    @GetMapping("/my")
    public List <BusinessResponse> getMyBusiness(){
        return businessService.getMyBusiness();
    }
}
