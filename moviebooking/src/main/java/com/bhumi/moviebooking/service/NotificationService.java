package com.bhumi.moviebooking.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public String sendNotification(String message) {
        return "Notification Sent: " + message;
    }
}