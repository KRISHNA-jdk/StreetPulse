package StreetPulse.StreetPulse.controllers;


import StreetPulse.StreetPulse.dto.BusinessRequest;
import StreetPulse.StreetPulse.dto.BusinessResponse;
import StreetPulse.StreetPulse.entity.Business;
import StreetPulse.StreetPulse.repository.BusinessRepository;
import StreetPulse.StreetPulse.services.BusinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/business")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService){
        this.businessService = businessService;
    }

    @PostMapping
    public Business createBusiness(@RequestBody BusinessRequest request){
        return businessService.createBusiness(request);
    }

    @GetMapping
    public List<Business> getAllBusiness(){
        return businessService.getAllBusiness();
    }

    @GetMapping("/{id}")
    public Business getBusinessById(@PathVariable long id){
        return businessService.getBusinessById(id);
    }

    @GetMapping("/trending")
    public List <BusinessResponse> getTrendingBusinesses(){
        return businessService.getTrendingBusiness();
    }
}
