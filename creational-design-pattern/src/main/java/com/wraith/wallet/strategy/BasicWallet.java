package com.wraith.wallet.strategy;

import com.wraith.wallet.api.Wallet;
import com.wraith.wallet.storage.Storage;

import java.util.concurrent.locks.ReentrantLock;

public class BasicWallet implements Wallet {

    private final String userId;
    private final Storage storage;
    private final ReentrantLock lock = new ReentrantLock();

    public BasicWallet(String userId, Storage storage) {
        this.userId = userId;
        this.storage = storage;
        storage.putIfAbsent(userId, 0.0);
    }

    @Override
    public void credit(double amount) {
        lock.lock();
        try {
            double balance = getBalance();
            storage.put(userId, balance + amount);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void debit(double amount) {
        lock.lock();
        try {
            double balance = getBalance();
            if (balance < amount) {
                throw new IllegalStateException("Insufficient funds");
            }
            storage.put(userId, balance - amount);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public double getBalance() {
        return (double) storage.get(userId);
    }
}