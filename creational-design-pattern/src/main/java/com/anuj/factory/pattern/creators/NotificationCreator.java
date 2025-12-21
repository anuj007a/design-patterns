package com.wraith.factory.pattern.creators;

import com.wraith.factory.pattern.service.EmailNotification;
import com.wraith.factory.pattern.service.Notification;
import com.wraith.factory.pattern.service.SmsNotification;

public abstract class NotificationCreator {

    // Factory Method
    protected abstract Notification createNotification();

    public void notifyUser() {
        Notification notification = createNotification();
        notification.send();
    }


    public void validate() {
        Notification notification = createNotification();
            notification.validate();
//        }
    }
}
