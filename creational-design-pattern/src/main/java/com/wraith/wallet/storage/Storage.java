package com.wraith.wallet.storage;

public interface Storage {
    Object get(String key);

    void put(String key, Object value);

    void putIfAbsent(String key, Object value);
}