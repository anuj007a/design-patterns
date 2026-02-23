package com.wraith.wallet.api;

public interface Wallet {
    void credit(double amount);
    void debit(double amount);
    double getBalance();
}