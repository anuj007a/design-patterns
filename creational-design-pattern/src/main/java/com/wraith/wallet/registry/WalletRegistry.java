package com.wraith.wallet.registry;

import com.wraith.wallet.api.Wallet;

import java.util.concurrent.ConcurrentHashMap;

public final class WalletRegistry {

    private final ConcurrentHashMap<String, Wallet> registry =
            new ConcurrentHashMap<>();

    private WalletRegistry() {}

    private static class Holder {
        private static final WalletRegistry INSTANCE =
                new WalletRegistry();
    }

    public static WalletRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public void register(String userId, Wallet wallet) {
        registry.put(userId, wallet);
    }

    public Wallet get(String userId) {
        return registry.get(userId);
    }
}