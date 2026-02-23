package com.wraith.ratelimiter.config;

public class RateLimiterConfig {

    private final int capacity;
    private final int refillRate;
    private final int limit;
    private final long windowMillis;

    public RateLimiterConfig(int capacity,
                             int refillRate,
                             int limit,
                             long windowMillis) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.limit = limit;
        this.windowMillis = windowMillis;
    }

    public int getCapacity() { return capacity; }
    public int getRefillRate() { return refillRate; }
    public int getLimit() { return limit; }
    public long getWindowMillis() { return windowMillis; }
}