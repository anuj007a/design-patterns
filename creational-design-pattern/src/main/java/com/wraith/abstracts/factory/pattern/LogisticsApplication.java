package com.wraith.abstracts.factory.pattern;

import com.wraith.abstracts.factory.pattern.abstractfactory.LogisticsFactory;
import com.wraith.abstracts.factory.pattern.abstractproducts.CostCalculator;
import com.wraith.abstracts.factory.pattern.abstractproducts.RoutePlanner;
import com.wraith.abstracts.factory.pattern.abstractproducts.Transport;
import com.wraith.abstracts.factory.pattern.concretefactory.RoadLogisticsFactory;
import com.wraith.abstracts.factory.pattern.concretefactory.SeaLogisticsFactory;

public class LogisticsApplication {

    private final Transport transport;
    private final RoutePlanner routePlanner;
    private final CostCalculator costCalculator;

    public LogisticsApplication(LogisticsFactory factory) {
        this.transport = factory.createTransport();
        this.routePlanner = factory.createRoutePlanner();
        this.costCalculator = factory.createCostCalculator();
    }

    public void deliver(double distance) {
        routePlanner.planRoute();
        transport.deliver();
        System.out.println("Total cost = " + costCalculator.calculateCost(distance));
    }

    public static void main(String[] args) {

        // Runtime decision
//        LogisticsFactory factory = new RoadLogisticsFactory();
         LogisticsFactory factory = new SeaLogisticsFactory();

        LogisticsApplication app = new LogisticsApplication(factory);
        app.deliver(100);
    }
}
