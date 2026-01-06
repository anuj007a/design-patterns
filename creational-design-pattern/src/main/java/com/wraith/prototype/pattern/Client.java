package com.wraith.prototype.pattern;

import com.wraith.prototype.pattern.concreteprototypes.NotificationTemplate;
import com.wraith.prototype.pattern.concreteprototypes.PrototypeRegistry;
import com.wraith.prototype.pattern.concreteprototypes.TransportPrototype;
import com.wraith.prototype.pattern.concreteprototypes.Config;

public class Client {
    public static void main(String[] args) {
        NotificationTemplate baseEmail =
                new NotificationTemplate("EMAIL", "HIGH", "Company Footer");

        NotificationTemplate emailForVip = baseEmail.clone();
        emailForVip.setPriority("CRITICAL");

        System.out.println(baseEmail);
        System.out.println(emailForVip);

        TransportPrototype truckTransport =
                new TransportPrototype("TRUCK", new Config("US"));
        TransportPrototype clonedTransport = truckTransport.clone();
        System.out.println(truckTransport);
        System.out.println(clonedTransport);

        NotificationTemplate sms =
                PrototypeRegistry.get("SMS");
        System.out.println(sms);
        sms.setPriority("HIGH");
        System.out.println(sms);

    }
}
