package com.paresh.project.Lovable.Clone.Dto.Subscription;

public record PlanResponse(
        Long id,
        String name,
        Integer maxProjects,
        Integer maxTokenPerDay,
        Boolean UnlimitedAi,
        String price
) {
}
