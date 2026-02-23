package com.wraith.ratelimiter.builder;

import com.wraith.ratelimiter.api.RateLimiter;
import com.wraith.ratelimiter.config.RateLimiterConfig;
import com.wraith.ratelimiter.factory.*;

public class RateLimiterBuilder {

    private RateLimiterConfig config;
    private RateLimiterCreator creator;
    private EnvironmentFactory environmentFactory;

    public RateLimiterBuilder config(RateLimiterConfig config) {
        this.config = config;
        return this;
    }

    public RateLimiterBuilder creator(RateLimiterCreator creator) {
        this.creator = creator;
        return this;
    }

    public RateLimiterBuilder environment(EnvironmentFactory factory) {
        this.environmentFactory = factory;
        return this;
    }

    public RateLimiter build() {
        return creator.createLimiter(
                config,
                environmentFactory.createStorage()
        );
    }
}