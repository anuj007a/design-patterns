package com.wraith.factory.pattern.notification.service;

public class EmailNotification extends BaseNotification {

    private final String emailId;

    public EmailNotification(String firstName,
                             String lastName,
                             String emailId) {
        super(firstName, lastName);
        this.emailId = emailId;
    }

    @Override
    public void send() {
        System.out.println(
                "Sending EMAIL to " + emailId +
                        " | User: " + fullName()
        );
    }

    @Override
    public void validate() {
        if ( !emailId.contains("@") ) {
            throw new IllegalArgumentException("Invalid email address: " + emailId);
        }
        System.out.println("Validating email address: " + emailId);
    }
}

