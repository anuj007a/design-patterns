package com.wraith.factory.pattern.notification.creators;

import com.wraith.factory.pattern.notification.service.Notification;

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
