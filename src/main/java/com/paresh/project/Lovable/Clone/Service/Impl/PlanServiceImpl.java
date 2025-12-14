package com.paresh.project.Lovable.Clone.Service.Impl;

import com.paresh.project.Lovable.Clone.Dto.Subscription.PlanResponse;
import com.paresh.project.Lovable.Clone.Service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
