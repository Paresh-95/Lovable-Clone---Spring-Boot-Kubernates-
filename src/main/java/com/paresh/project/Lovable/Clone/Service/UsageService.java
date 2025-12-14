package com.paresh.project.Lovable.Clone.Service;

import com.paresh.project.Lovable.Clone.Dto.Subscription.Usage.PlanLimitsResponse;
import com.paresh.project.Lovable.Clone.Dto.Subscription.Usage.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {
    UsageTodayResponse getTodayUsage(Long userId);

    PlanLimitsResponse getPlanLimits(Long userId);
}
