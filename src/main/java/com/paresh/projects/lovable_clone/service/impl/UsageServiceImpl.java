package com.paresh.projects.lovable_clone.service.impl;

import com.paresh.projects.lovable_clone.dto.usage.PlanLimitResponse;
import com.paresh.projects.lovable_clone.dto.usage.UsageTodayResponse;
import com.paresh.projects.lovable_clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimits(Long userId) {
        return null;
    }
}
