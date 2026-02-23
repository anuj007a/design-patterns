package com.wraith.wallet.strategy;


import com.wraith.wallet.storage.Storage;

public class PremiumWallet extends BasicWallet {

    private final double creditLimit;

    public PremiumWallet(String userId,
                         Storage storage,
                         double creditLimit) {
        super(userId, storage);
        this.creditLimit = creditLimit;
    }

    @Override
    public void debit(double amount) {
        double balance = getBalance();
        if (balance + creditLimit < amount) {
            throw new IllegalStateException("Limit exceeded");
        }
        super.debit(amount);
    }
}