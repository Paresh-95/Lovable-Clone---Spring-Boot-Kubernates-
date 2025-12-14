package com.paresh.project.Lovable.Clone.Entity;


import com.paresh.project.Lovable.Clone.Enum.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Subscription {

    Long id;

    User user;
    Plan plan;

    String stripeCustomerId;
    String stripeSubscriptionId;
    SubscriptionStatus status;

    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    Boolean cancelAtPeriodEnd;


    Instant createdAt;
    Instant updatedAt;

}
