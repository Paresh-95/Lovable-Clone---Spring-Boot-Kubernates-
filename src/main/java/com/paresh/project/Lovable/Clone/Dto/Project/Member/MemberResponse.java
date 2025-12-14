package com.paresh.project.Lovable.Clone.Dto.Project.Member;

import com.paresh.project.Lovable.Clone.Enum.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long id,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
