package com.paresh.project.Lovable.Clone.Dto.Auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl
) {
}
