package com.wraith.ratelimiter.factory;

import com.wraith.ratelimiter.api.RateLimiter;
import com.wraith.ratelimiter.config.RateLimiterConfig;
import com.wraith.ratelimiter.storage.Storage;
import com.wraith.ratelimiter.strategy.SlidingWindowRateLimiter;

public class SlidingWindowCreator extends RateLimiterCreator {

    @Override
    public RateLimiter createLimiter(
            RateLimiterConfig config,
            Storage storage) {

        if (config.getLimit() <= 0) {
            throw new IllegalArgumentException(
                    "SlidingWindow requires limit > 0");
        }

        if (config.getWindowMillis() <= 0) {
            throw new IllegalArgumentException(
                    "SlidingWindow requires windowMillis > 0");
        }

        return new SlidingWindowRateLimiter(
                config.getLimit(),
                config.getWindowMillis(),
                storage
        );
    }
}