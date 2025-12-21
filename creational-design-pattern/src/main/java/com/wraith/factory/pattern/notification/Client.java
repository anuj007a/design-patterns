package com.wraith.factory.pattern.notification;

import com.wraith.factory.pattern.notification.concretecreators.EmailNotificationCreator;
import com.wraith.factory.pattern.notification.creators.NotificationCreator;
import com.wraith.factory.pattern.notification.concretecreators.SmsNotificationCreator;

public class Client {
    public static void main(String[] args) {
        NotificationCreator emailCreator =
                new EmailNotificationCreator(
                        "wraith", "Ops", "wraith@test.com");

        NotificationCreator smsCreator =
                new SmsNotificationCreator(
                        "wraith", "Ops", 9876543210l);

        emailCreator.notifyUser();
        smsCreator.notifyUser();
    }
}
