package com.wraith.factory.pattern.service;

public class SmsNotification extends  BaseNotification {
    private final long phoneNumber;

    public SmsNotification(String firstName,
                           String lastName,
                           long phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        System.out.println(
                "Sending SMS to " + phoneNumber +
                        " | User: " + fullName()
        );
    }
    @Override
    public void validate() {
        if (phoneNumber < 1 || phoneNumber > 9999999999L) {
            throw new IllegalArgumentException("Invalid phone number: " + phoneNumber);
        }
        System.out.println("Validating phone number: " + phoneNumber);
    }
}
