package com.wraith.factory.pattern.notification.creators;

import com.wraith.factory.pattern.notification.product.Notification;

public abstract class NotificationCreator {

    // Factory Method
    protected abstract Notification createNotification();

    // Template Method
    public final void notifyUser() {
        Notification notification = createNotification();
//        notification.validate();
        notification.send();
    }
}
