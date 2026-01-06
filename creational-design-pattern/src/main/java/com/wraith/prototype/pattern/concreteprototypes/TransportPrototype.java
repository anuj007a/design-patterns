package com.wraith.prototype.pattern.concreteprototypes;

import com.wraith.prototype.pattern.prototypes.Prototype;

public class TransportPrototype implements Prototype<TransportPrototype> {

    private String mode;
    private Config config;

    public TransportPrototype(String mode, Config config) {
        this.mode = mode;
        this.config = new Config(config.region); // defensive copy
    }

    @Override
    public TransportPrototype clone() {
        return new TransportPrototype(
            this.mode,
            new Config(this.config.region) // deep copy of mutable field
        );
    }
}