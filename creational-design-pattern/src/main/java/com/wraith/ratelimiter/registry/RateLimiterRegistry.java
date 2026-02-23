package com.wraith.ratelimiter.registry;

import com.wraith.ratelimiter.api.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public final class RateLimiterRegistry {

    private final ConcurrentHashMap<String, RateLimiter>
            registry = new ConcurrentHashMap<>();

    private RateLimiterRegistry() {}

    private static class Holder {
        private static final RateLimiterRegistry INSTANCE =
                new RateLimiterRegistry();
    }

    public static RateLimiterRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public void register(String api, RateLimiter limiter) {
        registry.put(api, limiter);
    }

    public RateLimiter get(String api) {
        return registry.get(api);
    }
}