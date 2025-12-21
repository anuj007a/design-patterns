package com.wraith.factory.pattern;

import com.wraith.factory.pattern.creators.EmailNotificationCreator;
import com.wraith.factory.pattern.creators.NotificationCreator;
import com.wraith.factory.pattern.creators.SmsNotificationCreator;

public class Client {
    public static void main(String[] args) {
        NotificationCreator emailCreator =
                new EmailNotificationCreator(
                        "wraith", "Bharti", "wraith@test.com");

        NotificationCreator smsCreator =
                new SmsNotificationCreator(
                        "wraith", "Bharti", 9876543210l);

        emailCreator.notifyUser();
        emailCreator.validate();
        smsCreator.notifyUser();
        smsCreator.validate();
    }
}
