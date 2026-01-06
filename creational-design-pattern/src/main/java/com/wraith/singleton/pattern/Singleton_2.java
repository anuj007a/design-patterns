package com.wraith.singleton.pattern;

/*
Synchronized Method (Thread-Safe, Slow)
Trade-off
    Thread-safe
    Performance hit due to synchronization on every call
 */
public class Singleton_2 {

    private static Singleton_2 instance;

    private Singleton_2() {}

    public static synchronized Singleton_2 getInstance() {
        if (instance == null) {
            instance = new Singleton_2();
        }
        return instance;
    }
}
