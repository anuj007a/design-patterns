package com.wraith.factory.pattern.logistics.service;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering goods by ROAD using Truck");
    }
}
