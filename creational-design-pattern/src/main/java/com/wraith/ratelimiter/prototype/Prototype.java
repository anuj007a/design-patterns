package com.wraith.ratelimiter.prototype;

public interface Prototype<T> {
    T clone();
}