package com.paresh.projects.lovable_clone.service;

import com.paresh.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.paresh.projects.lovable_clone.dto.subscription.PortalResponse;
import com.paresh.projects.lovable_clone.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutResponse request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
