package com.wraith.factory.pattern.notification.baseproduct;

import com.wraith.factory.pattern.notification.product.Notification;

public abstract class BaseNotification implements Notification {

    protected final String firstName;
    protected final String lastName;

    protected BaseNotification(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected String fullName() {
        return firstName + " " + lastName;
    }
}
