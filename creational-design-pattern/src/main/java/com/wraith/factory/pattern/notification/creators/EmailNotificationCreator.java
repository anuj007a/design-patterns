package com.wraith.factory.pattern.notification.creators;

import com.wraith.factory.pattern.notification.service.EmailNotification;
import com.wraith.factory.pattern.notification.service.Notification;

public class EmailNotificationCreator extends NotificationCreator {
    private final String firstName;
    private final String lastName;
    private final String emailId;

    public EmailNotificationCreator(String firstName,
                                    String lastName,
                                    String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    @Override
    protected Notification createNotification() {
        return new EmailNotification(firstName, lastName, emailId);
    }
}

