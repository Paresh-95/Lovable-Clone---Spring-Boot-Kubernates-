package com.paresh.project.Lovable.Clone.Service;

import com.paresh.project.Lovable.Clone.Dto.Subscription.CheckoutRequest;
import com.paresh.project.Lovable.Clone.Dto.Subscription.CheckoutResponse;
import com.paresh.project.Lovable.Clone.Dto.Subscription.PortalResponse;
import com.paresh.project.Lovable.Clone.Dto.Subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal(Long userId);
}
