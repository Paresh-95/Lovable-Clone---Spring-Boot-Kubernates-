package com.paresh.projects.lovable_clone.service;


import com.paresh.projects.lovable_clone.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
