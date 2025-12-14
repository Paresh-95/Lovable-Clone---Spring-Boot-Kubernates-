package com.paresh.project.Lovable.Clone.Dto.Subscription.Usage;

public record UsageTodayResponse(
        Integer tokenUsed,
        Integer tokenLimit,
        Integer previewsRunning,
        Integer previewsLimit

) {
}
