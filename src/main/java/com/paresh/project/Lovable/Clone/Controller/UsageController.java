package com.paresh.project.Lovable.Clone.Controller;


import com.paresh.project.Lovable.Clone.Dto.Subscription.Usage.PlanLimitsResponse;
import com.paresh.project.Lovable.Clone.Dto.Subscription.Usage.UsageTodayResponse;
import com.paresh.project.Lovable.Clone.Service.UsageService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/usage")
public class UsageController {

    final private UsageService usageService;


    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getTodayUsage(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getTodayUsage(userId));
    }

    @GetMapping("/limits")
    public ResponseEntity<PlanLimitsResponse> getPlanLimits(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getPlanLimits(userId));
    }



}
