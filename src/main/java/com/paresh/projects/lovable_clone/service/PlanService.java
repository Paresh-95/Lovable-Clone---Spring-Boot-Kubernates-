package com.paresh.projects.lovable_clone.service;

import com.paresh.projects.lovable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlan();
}
