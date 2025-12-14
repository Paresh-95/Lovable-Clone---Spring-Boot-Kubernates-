package com.paresh.project.Lovable.Clone.Dto.Project;

import com.paresh.project.Lovable.Clone.Dto.Auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner

) {
}
