package com.paresh.project.Lovable.Clone.Dto.Subscription.Usage;


public record PlanLimitsResponse(
        String planName,
        Integer maxTokenPerDay,
        Integer maxProjects,
        Boolean unlimitedAi
) {
}
