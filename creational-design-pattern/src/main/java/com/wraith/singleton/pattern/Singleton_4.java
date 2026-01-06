package com.wraith.singleton.pattern;
/*
Best Practice: Bill Pugh (Initialization-on-Demand Holder)
Why this is best
    ✔ Lazy initialization
    ✔ Thread-safe
    ✔ No synchronization overhead
    ✔ Clean & readable
 */
public class Singleton_4 {

    private Singleton_4() {}

    private static class Holder {
        private static final Singleton_4 INSTANCE = new Singleton_4();
    }

    public static Singleton_4 getInstance() {
        return Holder.INSTANCE;
    }
}
