package com.wraith.abstracts.factory.pattern.concreteproducts;

import com.wraith.abstracts.factory.pattern.abstractproducts.CostCalculator;

public class RoadCostCalculator implements CostCalculator {
    @Override
    public double calculateCost(double distance) {
        return distance * 10; // example rate
    }
}
