package com.paresh.projects.lovable_clone.service.impl;

import com.paresh.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.paresh.projects.lovable_clone.dto.subscription.PortalResponse;
import com.paresh.projects.lovable_clone.dto.subscription.SubscriptionResponse;
import com.paresh.projects.lovable_clone.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutResponse request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
