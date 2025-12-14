package com.paresh.project.Lovable.Clone.Dto.Project;

import com.paresh.project.Lovable.Clone.Entity.Project;

import java.time.Instant;
import java.util.List;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
}
