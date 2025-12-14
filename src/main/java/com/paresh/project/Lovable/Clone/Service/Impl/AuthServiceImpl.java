package com.paresh.project.Lovable.Clone.Service.Impl;

import com.paresh.project.Lovable.Clone.Dto.Auth.AuthResponse;
import com.paresh.project.Lovable.Clone.Dto.Auth.LoginRequest;
import com.paresh.project.Lovable.Clone.Dto.Auth.SignupRequest;
import com.paresh.project.Lovable.Clone.Service.AuthService;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
