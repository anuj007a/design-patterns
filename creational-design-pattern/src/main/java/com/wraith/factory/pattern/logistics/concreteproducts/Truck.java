package com.wraith.factory.pattern.logistics.concreteproducts;

import com.wraith.factory.pattern.logistics.product.Transport;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering goods by ROAD using Truck");
    }
}
