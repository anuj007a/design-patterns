package com.wraith.ratelimiter.api;

public interface RateLimiter {
    boolean allow(String key);
}