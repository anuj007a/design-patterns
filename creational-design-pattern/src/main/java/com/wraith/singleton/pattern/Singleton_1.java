package com.wraith.singleton.pattern;

/*
NOT Thread-Safe
Problem: Multiple threads can create multiple instances
 */

public class Singleton_1 {

    private static Singleton_1 instance;

    private Singleton_1() {}

    public static Singleton_1 getInstance() {
        if (instance == null) {
            instance = new Singleton_1(); // ❌ race condition
        }
        return instance;
    }
}
