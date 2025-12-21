package com.wraith.builder.pattern.car.builder;

import com.wraith.builder.pattern.car.cars.CarType;
import com.wraith.builder.pattern.car.components.Engine;
import com.wraith.builder.pattern.car.components.GPSNavigator;
import com.wraith.builder.pattern.car.components.Transmission;
import com.wraith.builder.pattern.car.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}