package com.example.pidevthecreators.entities;

public enum SatisfactoryStatus {
    satisfied,not_satisfied;

    public static class SmsRequest {

        private final String phoneNumber; //destination
        private final String message;
        public SmsRequest(String phoneNumber, String message) {
            this.phoneNumber = phoneNumber;
            this.message = message;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "SmsRequest{" +
                    "phoneNumber='" + phoneNumber + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
