package com.paresh.projects.lovable_clone.service.impl;

import com.paresh.projects.lovable_clone.dto.auth.AuthResponse;
import com.paresh.projects.lovable_clone.dto.auth.LoginRequest;
import com.paresh.projects.lovable_clone.dto.auth.SignupRequest;
import com.paresh.projects.lovable_clone.entity.User;
import com.paresh.projects.lovable_clone.error.BadRequestException;
import com.paresh.projects.lovable_clone.mapper.UserMapper;
import com.paresh.projects.lovable_clone.repository.UserRepository;
import com.paresh.projects.lovable_clone.security.AuthUtil;
import com.paresh.projects.lovable_clone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthUtil authUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username())
                .ifPresent(
                user ->{
                    throw new BadRequestException("User already exist with username "+request.username());
                }
        );

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);
        String token = authUtil.generateAccessToken(user);
        return new AuthResponse(token,userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(),request.password())
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);
        return new AuthResponse(token,userMapper.toUserProfileResponse(user));

    }
}
