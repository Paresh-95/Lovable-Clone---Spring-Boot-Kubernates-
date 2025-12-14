package com.paresh.project.Lovable.Clone.Service.Impl;

import com.paresh.project.Lovable.Clone.Dto.Subscription.CheckoutRequest;
import com.paresh.project.Lovable.Clone.Dto.Subscription.CheckoutResponse;
import com.paresh.project.Lovable.Clone.Dto.Subscription.PortalResponse;
import com.paresh.project.Lovable.Clone.Dto.Subscription.SubscriptionResponse;
import com.paresh.project.Lovable.Clone.Service.SubscriptionService;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
