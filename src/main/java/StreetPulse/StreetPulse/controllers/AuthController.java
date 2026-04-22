package StreetPulse.StreetPulse.controllers;

import StreetPulse.StreetPulse.dto.AuthResponse;
import StreetPulse.StreetPulse.dto.LoginRequest;
import StreetPulse.StreetPulse.dto.RegisterRequest;
import StreetPulse.StreetPulse.dto.RegisterRequest;
import StreetPulse.StreetPulse.entity.User;
import StreetPulse.StreetPulse.repository.UserRepository;
import StreetPulse.StreetPulse.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest req){
        return userService.register(req);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req){
        return userService.login(req);
    }
}
