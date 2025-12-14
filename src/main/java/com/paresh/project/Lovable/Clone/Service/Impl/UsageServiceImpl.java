package com.paresh.project.Lovable.Clone.Service.Impl;

import com.paresh.project.Lovable.Clone.Dto.Subscription.Usage.PlanLimitsResponse;
import com.paresh.project.Lovable.Clone.Dto.Subscription.Usage.UsageTodayResponse;
import com.paresh.project.Lovable.Clone.Service.UsageService;
import org.springframework.stereotype.Service;


@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsage(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getPlanLimits(Long userId) {
        return null;
    }
}
