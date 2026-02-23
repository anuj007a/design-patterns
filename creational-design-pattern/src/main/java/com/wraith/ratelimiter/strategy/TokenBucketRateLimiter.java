package com.wraith.ratelimiter.strategy;

import com.wraith.ratelimiter.api.RateLimiter;
import com.wraith.ratelimiter.prototype.Prototype;
import com.wraith.ratelimiter.storage.Storage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketRateLimiter
        implements RateLimiter,
                   Prototype<TokenBucketRateLimiter> {

    private final int capacity;
    private final double refillRatePerMillis;
    private final Storage storage;

    private final ConcurrentHashMap<String, ReentrantLock> locks =
            new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int capacity,
                                   int refillPerSecond,
                                   Storage storage) {
        this.capacity = capacity;
        this.refillRatePerMillis =
                refillPerSecond / 1000.0;
        this.storage = storage;
    }

    @Override
    public boolean allow(String key) {

        locks.putIfAbsent(key, new ReentrantLock());
        ReentrantLock lock = locks.get(key);

        lock.lock();
        try {
            Bucket bucket = (Bucket) storage.get(key);
            long now = System.currentTimeMillis();

            if (bucket == null) {
                bucket = new Bucket(capacity, now);
                storage.put(key, bucket);
            }

            long elapsed = now - bucket.lastRefillTime;
            double refill = elapsed * refillRatePerMillis;

            bucket.tokens = Math.min(
                    capacity,
                    bucket.tokens + refill
            );
            bucket.lastRefillTime = now;

            if (bucket.tokens >= 1) {
                bucket.tokens -= 1;
                return true;
            }

            return false;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public TokenBucketRateLimiter clone() {
        return new TokenBucketRateLimiter(
                capacity,
                (int)(refillRatePerMillis * 1000),
                storage
        );
    }

    private static class Bucket {
        double tokens;
        long lastRefillTime;

        Bucket(double tokens, long time) {
            this.tokens = tokens;
            this.lastRefillTime = time;
        }
    }
}