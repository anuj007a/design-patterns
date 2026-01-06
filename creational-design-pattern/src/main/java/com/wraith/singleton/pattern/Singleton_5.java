package com.wraith.singleton.pattern;

/*
Enum Singleton (Safest)
Why interviewers like this
    ✔ Serialization-safe
    ✔ Reflection-safe
    ✔ Simple
    ✔ JVM guarantees single instance
 */
public enum Singleton_5 {
    INSTANCE;

    public void doSomething() {
        System.out.println("Singleton via enum");
    }
}
