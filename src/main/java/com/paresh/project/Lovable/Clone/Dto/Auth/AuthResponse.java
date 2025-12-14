package com.paresh.project.Lovable.Clone.Dto.Auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}
