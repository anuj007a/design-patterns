package com.wraith.singleton.pattern;

/*
Double-Checked Locking (Tricky, Error-Prone)
Works only with volatile, still complex.
 */
public class Singleton_3 {

    private static volatile Singleton_3 instance;

    private Singleton_3() {}

    public static Singleton_3 getInstance() {
        if (instance == null) {
            synchronized (Singleton_3.class) {
                if (instance == null) {
                    instance = new Singleton_3();
                }
            }
        }
        return instance;
    }
}