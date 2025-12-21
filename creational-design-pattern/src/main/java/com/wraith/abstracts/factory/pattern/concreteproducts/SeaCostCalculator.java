package com.wraith.abstracts.factory.pattern.concreteproducts;

import com.wraith.abstracts.factory.pattern.abstractproducts.CostCalculator;

public class SeaCostCalculator implements CostCalculator {
    @Override
    public double calculateCost(double distance) {
        return distance * 5; // cheaper per km
    }
}
