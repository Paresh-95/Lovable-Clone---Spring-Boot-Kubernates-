package com.paresh.project.Lovable.Clone.Service;

import com.paresh.project.Lovable.Clone.Dto.Auth.AuthResponse;
import com.paresh.project.Lovable.Clone.Dto.Auth.LoginRequest;
import com.paresh.project.Lovable.Clone.Dto.Auth.SignupRequest;
import org.jspecify.annotations.Nullable;


public interface AuthService {
     AuthResponse signup(SignupRequest request);

     AuthResponse login(LoginRequest request);
}
