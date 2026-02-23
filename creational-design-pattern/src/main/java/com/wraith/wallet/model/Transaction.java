package com.wraith.wallet.model;

import com.wraith.wallet.prototype.Prototype;

public class Transaction implements Prototype<Transaction> {

    private final String type;
    private final double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() { return type; }
    public double getAmount() { return amount; }

    @Override
    public Transaction clone() {
        return new Transaction(type, amount);
    }
}