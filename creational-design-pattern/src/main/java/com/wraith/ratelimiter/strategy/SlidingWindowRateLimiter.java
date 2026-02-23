package com.wraith.ratelimiter.strategy;

import com.wraith.ratelimiter.api.RateLimiter;
import com.wraith.ratelimiter.prototype.Prototype;
import com.wraith.ratelimiter.storage.Storage;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindowRateLimiter
        implements RateLimiter,
                   Prototype<SlidingWindowRateLimiter> {

    private final int limit;
    private final long windowMillis;
    private final Storage storage;

    private final ConcurrentHashMap<String, ReentrantLock> locks =
            new ConcurrentHashMap<>();

    public SlidingWindowRateLimiter(int limit,
                                     long windowMillis,
                                     Storage storage) {
        this.limit = limit;
        this.windowMillis = windowMillis;
        this.storage = storage;
    }

    @Override
    public boolean allow(String key) {

        locks.putIfAbsent(key, new ReentrantLock());
        ReentrantLock lock = locks.get(key);

        lock.lock();
        try {
            long now = System.currentTimeMillis();

            Deque<Long> timestamps =
                    (Deque<Long>) storage.get(key);

            if (timestamps == null) {
                timestamps = new LinkedList<>();
                storage.put(key, timestamps);
            }

            while (!timestamps.isEmpty() &&
                    now - timestamps.peekFirst() > windowMillis) {
                timestamps.pollFirst();
            }

            if (timestamps.size() < limit) {
                timestamps.addLast(now);
                return true;
            }

            return false;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public SlidingWindowRateLimiter clone() {
        return new SlidingWindowRateLimiter(
                limit,
                windowMillis,
                storage
        );
    }
}