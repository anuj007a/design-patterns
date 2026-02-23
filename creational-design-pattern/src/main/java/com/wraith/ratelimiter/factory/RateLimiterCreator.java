package com.wraith.ratelimiter.factory;

import com.wraith.ratelimiter.api.RateLimiter;
import com.wraith.ratelimiter.config.RateLimiterConfig;
import com.wraith.ratelimiter.storage.Storage;

public abstract class RateLimiterCreator {

    public abstract RateLimiter createLimiter(
            RateLimiterConfig config,
            Storage storage
    );
}