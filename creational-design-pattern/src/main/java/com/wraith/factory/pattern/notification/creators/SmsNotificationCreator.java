package com.wraith.factory.pattern.notification.creators;

import com.wraith.factory.pattern.notification.service.Notification;
import com.wraith.factory.pattern.notification.service.SmsNotification;

public class SmsNotificationCreator extends NotificationCreator {
    private final String firstName;
    private final String lastName;
    private final long phoneNumber;

    public SmsNotificationCreator(String firstName,
                                  String lastName,
                                  long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected Notification createNotification() {
        return new SmsNotification(firstName, lastName, phoneNumber);
    }
}
