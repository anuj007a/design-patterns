package com.wraith.prototype.pattern.concreteprototypes;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {

    private static final Map<String, NotificationTemplate> registry =
            new HashMap<>();

    static {
        registry.put("EMAIL",
            new NotificationTemplate("EMAIL", "NORMAL", "Footer"));
        registry.put("SMS",
            new NotificationTemplate("SMS", "LOW", "Footer"));
    }

    public static NotificationTemplate get(String type) {
        return registry.get(type).clone();
    }
}
