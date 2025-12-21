package com.wraith.builder.pattern.notification.builder;

import com.wraith.builder.pattern.notification.product.Channel;
import com.wraith.builder.pattern.notification.product.Notification;

public class Builder {

        // Required
        public final String firstName;
        public final String lastName;
        public final Channel channel;

        // Optional (defaults)
        public String emailId;
        public Long phoneNumber;
        public boolean retryEnabled = false;
        public int priority = 1;

        public Builder(String firstName, String lastName, Channel channel) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.channel = channel;
        }

        public Builder emailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        public Builder phoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder retryEnabled(boolean retryEnabled) {
            this.retryEnabled = retryEnabled;
            return this;
        }

        public Builder priority(int priority) {
            this.priority = priority;
            return this;
        }

        public Notification build() {
            validate();
            return new Notification(this);
        }

        private void validate() {
            if (firstName == null || lastName == null) {
                throw new IllegalStateException("Name is mandatory");
            }

            if (channel == Channel.EMAIL) {
                if (emailId == null || !emailId.contains("@")) {
                    throw new IllegalStateException("Valid email is required for EMAIL channel");
                }
            }

            if (channel == Channel.SMS) {
                if (phoneNumber == null || phoneNumber < 1000000000L) {
                    throw new IllegalStateException("Valid phone number is required for SMS channel");
                }
            }
        }
    }
