package com.wraith.ratelimiter.pool;

import com.wraith.ratelimiter.api.RateLimiter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class RateLimiterPool {

    private final BlockingQueue<RateLimiter> pool;

    public RateLimiterPool(int size,
                           RateLimiter prototype) {

        pool = new ArrayBlockingQueue<>(size);

        for (int i = 0; i < size; i++) {
            pool.add(prototype);
        }
    }

    public RateLimiter acquire()
            throws InterruptedException {
        return pool.take();
    }

    public void release(RateLimiter limiter) {
        pool.offer(limiter);
    }
}