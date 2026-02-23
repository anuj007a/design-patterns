package com.wraith.ratelimiter.app;

import com.wraith.ratelimiter.api.RateLimiter;
import com.wraith.ratelimiter.builder.RateLimiterBuilder;
import com.wraith.ratelimiter.config.RateLimiterConfig;
import com.wraith.ratelimiter.factory.*;
import com.wraith.ratelimiter.registry.RateLimiterRegistry;

public class RateLimiterApplication {

    public static void main(String[] args)
            throws InterruptedException {

        // -----------------------------
        // TOKEN BUCKET LIMITER
        // -----------------------------
        RateLimiter tokenLimiter =
                new RateLimiterBuilder()
                        .config(new RateLimiterConfig(
                                5, 2, 0, 0))
                        .creator(new TokenBucketCreator())
                        .environment(
                                new InMemoryEnvironmentFactory())
                        .build();

        RateLimiterRegistry.getInstance()
                .register("login-api", tokenLimiter);

        // -----------------------------
        // SLIDING WINDOW LIMITER
        // -----------------------------
        RateLimiter slidingLimiter =
                new RateLimiterBuilder()
                        .config(new RateLimiterConfig(
                                0, 0, 5, 5000))
                        .creator(new SlidingWindowCreator())
                        .environment(
                                new InMemoryEnvironmentFactory())
                        .build();

        RateLimiterRegistry.getInstance()
                .register("search-api", slidingLimiter);

        // -----------------------------
        // TEST TOKEN BUCKET
        // -----------------------------
        System.out.println("===== TOKEN BUCKET =====");
        RateLimiter loginLimiter =
                RateLimiterRegistry.getInstance()
                        .get("login-api");

        for (int i = 1; i <= 10; i++) {
            System.out.println("Login Request " + i +
                    " allowed: " +
                    loginLimiter.allow("user-1"));
            Thread.sleep(500);
        }

        Thread.sleep(3000); // allow refill

        // -----------------------------
        // TEST SLIDING WINDOW
        // -----------------------------
        System.out.println("\n===== SLIDING WINDOW =====");

        RateLimiter searchLimiter =
                RateLimiterRegistry.getInstance()
                        .get("search-api");

        for (int i = 1; i <= 10; i++) {
            System.out.println("Search Request " + i +
                    " allowed: " +
                    searchLimiter.allow("user-1"));
            Thread.sleep(500);
        }
    }
}