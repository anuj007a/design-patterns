package com.wraith.abstracts.factory.pattern.abstractfactory;

import com.wraith.abstracts.factory.pattern.abstractproducts.CostCalculator;
import com.wraith.abstracts.factory.pattern.abstractproducts.RoutePlanner;
import com.wraith.abstracts.factory.pattern.abstractproducts.Transport;

public interface LogisticsFactory {

    Transport createTransport();

    RoutePlanner createRoutePlanner();

    CostCalculator createCostCalculator();
}
