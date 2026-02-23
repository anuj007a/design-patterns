package com.wraith.wallet.model;

import java.util.UUID;

public class WalletSession {

    private final String sessionId;

    public WalletSession() {
        this.sessionId = UUID.randomUUID().toString();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void open() {
        System.out.println("Opening session: " + sessionId);
    }

    public void close() {
        System.out.println("Closing session: " + sessionId);
    }
}