package com.wraith.abstracts.factory.pattern.concretefactory;

import com.wraith.abstracts.factory.pattern.abstractfactory.LogisticsFactory;
import com.wraith.abstracts.factory.pattern.abstractproducts.CostCalculator;
import com.wraith.abstracts.factory.pattern.abstractproducts.RoutePlanner;
import com.wraith.abstracts.factory.pattern.abstractproducts.Transport;
import com.wraith.abstracts.factory.pattern.concreteproducts.RoadCostCalculator;
import com.wraith.abstracts.factory.pattern.concreteproducts.RoadRoutePlanner;
import com.wraith.abstracts.factory.pattern.concreteproducts.Truck;

public class RoadLogisticsFactory implements LogisticsFactory {

    @Override
    public Transport createTransport() {
        return new Truck();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new RoadRoutePlanner();
    }

    @Override
    public CostCalculator createCostCalculator() {
        return new RoadCostCalculator();
    }
}
