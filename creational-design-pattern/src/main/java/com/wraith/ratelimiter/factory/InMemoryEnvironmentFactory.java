package com.wraith.ratelimiter.factory;

import com.wraith.ratelimiter.storage.InMemoryStorage;
import com.wraith.ratelimiter.storage.Storage;

public class InMemoryEnvironmentFactory
        implements EnvironmentFactory {

    @Override
    public Storage createStorage() {
        return new InMemoryStorage();
    }
}