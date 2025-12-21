package com.wraith.factory.pattern.logistics.concretecreators;

import com.wraith.factory.pattern.logistics.concreteproducts.Ship;
import com.wraith.factory.pattern.logistics.creators.Logistics;
import com.wraith.factory.pattern.logistics.product.Transport;

public class SeaLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}
