package com.wraith.builder.pattern.notification.product;

import com.wraith.builder.pattern.notification.builder.Builder;

public final class Notification {
    private final String firstName;
    private final String lastName;
    private final Channel channel;
    private final String emailId;
    private final Long phoneNumber;
    private final boolean retryEnabled;
    private final int priority;

    public Notification(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.channel = builder.channel;
        this.emailId = builder.emailId;
        this.phoneNumber = builder.phoneNumber;
        this.retryEnabled = builder.retryEnabled;
        this.priority = builder.priority;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getEmailId() {
        return emailId;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isRetryEnabled() {
        return retryEnabled;
    }

    public int getPriority() {
        return priority;
    }
}