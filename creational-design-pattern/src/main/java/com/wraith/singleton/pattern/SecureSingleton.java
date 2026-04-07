package com.wraith.singleton.pattern;

import java.io.Serializable;

public class SecureSingleton implements Serializable {
    private static boolean instanceCreated = false;

    private SecureSingleton() {
        if (instanceCreated) {
            throw new RuntimeException("Singleton already created");
        }
        instanceCreated = true;
    }

    private static class Holder {
        private static final SecureSingleton INSTANCE =
                new SecureSingleton();
    }

    public static SecureSingleton getInstance() {
        return Holder.INSTANCE;
    }

    private Object readResolve() {
        return Holder.INSTANCE;
    }

    @Override
    protected Object clone()
            throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

