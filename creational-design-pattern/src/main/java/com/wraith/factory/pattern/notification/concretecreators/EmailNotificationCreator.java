package com.wraith.factory.pattern.notification.concretecreators;

import com.wraith.factory.pattern.notification.creators.NotificationCreator;
import com.wraith.factory.pattern.notification.concreteproducts.EmailNotification;
import com.wraith.factory.pattern.notification.product.Notification;

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

