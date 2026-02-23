package com.wraith.wallet.config;

public class WalletConfig {

    private final String userId;
    private final double creditLimit;

    public WalletConfig(String userId, double creditLimit) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("UserId required");
        }
        if (creditLimit < 0) {
            throw new IllegalArgumentException("Credit limit cannot be negative");
        }

        this.userId = userId;
        this.creditLimit = creditLimit;
    }

    public String getUserId() {
        return userId;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}