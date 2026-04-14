package StreetPulse.StreetPulse.controllers;

import StreetPulse.StreetPulse.dto.AuthResponse;
import StreetPulse.StreetPulse.dto.LoginRequest;
import StreetPulse.StreetPulse.dto.RegisterRequest;
import StreetPulse.StreetPulse.dto.RegisterRequest;
import StreetPulse.StreetPulse.entity.User;
import StreetPulse.StreetPulse.repository.UserRepository;
import StreetPulse.StreetPulse.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest req){
        return userService.register(req);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req){
        return userService.login(req);
    }
}
