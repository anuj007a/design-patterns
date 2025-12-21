package com.wraith.factory.pattern.logistics.creators;

import com.wraith.factory.pattern.logistics.service.Transport;

public abstract class Logistics {

    // Factory Method
    protected abstract Transport createTransport();

    // Business Logic
    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
