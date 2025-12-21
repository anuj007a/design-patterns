package com.wraith.factory.pattern.logistics.service;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering goods by SEA using Ship");
    }
}
