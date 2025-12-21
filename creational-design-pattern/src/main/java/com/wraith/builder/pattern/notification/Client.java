package com.wraith.builder.pattern.notification;


import com.wraith.builder.pattern.notification.builder.Builder;
import com.wraith.builder.pattern.notification.director.NotificationDirector;
import com.wraith.builder.pattern.notification.product.Channel;
import com.wraith.builder.pattern.notification.product.Notification;

public class Client {

    public static void main(String[] args) {

        NotificationDirector director = new NotificationDirector();

        Notification email =
                director.createHighPriorityEmail(
                        "Wraith",
                        "Ops",
                        "wraith@test.com"
                );

        Notification sms =
                director.createSmsAlert(
                        "Wraith",
                        "Ops",
                        9876543210L
                );

        System.out.println(email.getChannel() + " -> " + email.getFullName());
        System.out.println(sms.getChannel() + " -> " + sms.getFullName());
    }
}
