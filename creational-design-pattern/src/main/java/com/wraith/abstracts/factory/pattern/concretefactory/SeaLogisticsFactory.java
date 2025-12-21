package com.wraith.abstracts.factory.pattern.concretefactory;

import com.wraith.abstracts.factory.pattern.abstractfactory.LogisticsFactory;
import com.wraith.abstracts.factory.pattern.abstractproducts.CostCalculator;
import com.wraith.abstracts.factory.pattern.abstractproducts.RoutePlanner;
import com.wraith.abstracts.factory.pattern.abstractproducts.Transport;
import com.wraith.abstracts.factory.pattern.concreteproducts.SeaCostCalculator;
import com.wraith.abstracts.factory.pattern.concreteproducts.SeaRoutePlanner;
import com.wraith.abstracts.factory.pattern.concreteproducts.Ship;

public class SeaLogisticsFactory implements LogisticsFactory {

    @Override
    public Transport createTransport() {
        return new Ship();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new SeaRoutePlanner();
    }

    @Override
    public CostCalculator createCostCalculator() {
        return new SeaCostCalculator();
    }
}
