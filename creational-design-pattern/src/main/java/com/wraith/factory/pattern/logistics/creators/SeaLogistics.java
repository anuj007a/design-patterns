package com.wraith.factory.pattern.logistics.creators;

import com.wraith.factory.pattern.logistics.service.Ship;
import com.wraith.factory.pattern.logistics.service.Transport;

public class SeaLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}
