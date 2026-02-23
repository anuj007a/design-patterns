package com.wraith.wallet.pool;

import com.wraith.wallet.model.WalletSession;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WalletSessionPool {

    private final BlockingQueue<WalletSession> pool;

    public WalletSessionPool(int size) {
        pool = new ArrayBlockingQueue<>(size);
        for (int i = 0; i < size; i++) {
            pool.add(new WalletSession());
        }
    }

    public WalletSession acquire()
            throws InterruptedException {
        return pool.take();
    }

    public void release(WalletSession session) {
        pool.offer(session);
    }
}