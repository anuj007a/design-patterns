package com.wraith.abstracts.factory.pattern.concreteproducts;

import com.wraith.abstracts.factory.pattern.abstractproducts.RoutePlanner;

public class SeaRoutePlanner implements RoutePlanner {
    @Override
    public void planRoute() {
        System.out.println("Planning SEA route");
    }
}
