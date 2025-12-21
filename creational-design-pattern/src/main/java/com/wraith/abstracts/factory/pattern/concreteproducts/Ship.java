package com.wraith.abstracts.factory.pattern.concreteproducts;

import com.wraith.abstracts.factory.pattern.abstractproducts.Transport;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering goods by SEA using Ship");
    }
}
