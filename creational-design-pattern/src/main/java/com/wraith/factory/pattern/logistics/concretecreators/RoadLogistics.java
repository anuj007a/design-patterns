package com.wraith.factory.pattern.logistics.concretecreators;

import com.wraith.factory.pattern.logistics.creators.Logistics;
import com.wraith.factory.pattern.logistics.product.Transport;
import com.wraith.factory.pattern.logistics.concreteproducts.Truck;

public class RoadLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}
