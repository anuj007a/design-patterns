package com.wraith.factory.pattern.logistics.creators;

import com.wraith.factory.pattern.logistics.service.Transport;
import com.wraith.factory.pattern.logistics.service.Truck;

public class RoadLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}
