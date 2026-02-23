package com.wraith.ratelimiter.storage;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStorage implements Storage {

    private final ConcurrentHashMap<String, Object> store =
            new ConcurrentHashMap<>();

    @Override
    public Object get(String key) {
        return store.get(key);
    }

    @Override
    public void put(String key, Object value) {
        store.put(key, value);
    }
}