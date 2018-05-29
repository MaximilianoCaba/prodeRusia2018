package com.prode.service;

public interface MessengerService {

    void sendNotificationWorkplace(String urlPage, String message)throws  Exception;

    void sendNotificationMail(String title, String message);
}

