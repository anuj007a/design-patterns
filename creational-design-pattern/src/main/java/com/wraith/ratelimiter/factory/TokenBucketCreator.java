package com.wraith.ratelimiter.factory;

import com.wraith.ratelimiter.api.RateLimiter;
import com.wraith.ratelimiter.config.RateLimiterConfig;
import com.wraith.ratelimiter.storage.Storage;
import com.wraith.ratelimiter.strategy.TokenBucketRateLimiter;

public class TokenBucketCreator extends RateLimiterCreator {

    @Override
    public RateLimiter createLimiter(
            RateLimiterConfig config,
            Storage storage) {

        if (config.getCapacity() <= 0) {
            throw new IllegalArgumentException(
                    "TokenBucket requires capacity > 0");
        }

        if (config.getRefillRate() <= 0) {
            throw new IllegalArgumentException(
                    "TokenBucket requires refillRate > 0");
        }

        return new TokenBucketRateLimiter(
                config.getCapacity(),
                config.getRefillRate(),
                storage
        );
    }
}