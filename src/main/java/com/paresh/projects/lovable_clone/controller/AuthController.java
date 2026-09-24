package com.paresh.projects.lovable_clone.controller;


import com.paresh.projects.lovable_clone.dto.auth.AuthResponse;
import com.paresh.projects.lovable_clone.dto.auth.LoginRequest;
import com.paresh.projects.lovable_clone.dto.auth.SignupRequest;
import com.paresh.projects.lovable_clone.dto.auth.UserProfileResponse;
import com.paresh.projects.lovable_clone.service.AuthService;
import com.paresh.projects.lovable_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignupRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }

}
