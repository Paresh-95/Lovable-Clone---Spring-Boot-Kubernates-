package com.paresh.project.Lovable.Clone.Service;

import com.paresh.project.Lovable.Clone.Dto.Auth.UserProfileResponse;

public interface UserService {
     UserProfileResponse getProfile(Long userId);
}
