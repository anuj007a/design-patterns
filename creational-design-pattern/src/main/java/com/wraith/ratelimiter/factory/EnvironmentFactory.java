package com.wraith.ratelimiter.factory;

import com.wraith.ratelimiter.storage.Storage;

public interface EnvironmentFactory {
    Storage createStorage();
}