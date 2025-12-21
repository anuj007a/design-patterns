package com.wraith.abstracts.factory.pattern.concreteproducts;

import com.wraith.abstracts.factory.pattern.abstractproducts.Transport;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering goods by ROAD using Truck");
    }
}
