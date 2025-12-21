package com.wraith.builder.pattern.notification.director;

import com.wraith.builder.pattern.notification.builder.Builder;
import com.wraith.builder.pattern.notification.product.Channel;
import com.wraith.builder.pattern.notification.product.Notification;

public class NotificationDirector {

    public Notification createHighPriorityEmail(String firstName,
                                                 String lastName,
                                                 String emailId) {
        return new Builder(firstName, lastName, Channel.EMAIL)
                .emailId(emailId)
                .priority(5)
                .retryEnabled(true)
                .build();
    }

    public Notification createSmsAlert(String firstName,
                                       String lastName,
                                       long phoneNumber) {
        return new Builder(firstName, lastName, Channel.SMS)
                .phoneNumber(phoneNumber)
                .priority(3)
                .build();
    }
}
