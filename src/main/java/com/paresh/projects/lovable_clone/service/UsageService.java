package com.paresh.projects.lovable_clone.service;

import com.paresh.projects.lovable_clone.dto.usage.PlanLimitResponse;
import com.paresh.projects.lovable_clone.dto.usage.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitResponse getCurrentSubscriptionLimits(Long userId);
}
