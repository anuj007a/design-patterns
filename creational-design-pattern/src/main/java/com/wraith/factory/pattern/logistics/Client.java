package com.wraith.factory.pattern.logistics;

import com.wraith.factory.pattern.logistics.creators.Logistics;
import com.wraith.factory.pattern.logistics.creators.RoadLogistics;
import com.wraith.factory.pattern.logistics.creators.SeaLogistics;

public class Client {
    public static void main(String[] args) {

        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();

        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
    }
}
