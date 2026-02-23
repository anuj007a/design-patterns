package com.wraith.ratelimiter.storage;

public interface Storage {
    Object get(String key);
    void put(String key, Object value);
}