package com.wraith.prototype.pattern.concreteprototypes;

import com.wraith.prototype.pattern.prototypes.Prototype;

public class NotificationTemplate implements Prototype<NotificationTemplate> {

    private String channel;
    private String priority;
    private String footer;

    public NotificationTemplate(String channel,
                                String priority,
                                String footer) {
        this.channel = channel;
        this.priority = priority;
        this.footer = footer;
    }

    @Override
    public NotificationTemplate clone() {
        return new NotificationTemplate(channel, priority, footer);
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Channel=" + channel +
               ", Priority=" + priority +
               ", Footer=" + footer;
    }
}
