package com.prode.service;

public interface MessengerService {

    Boolean sendNotificationWorkplace(String urlTravel, String data)throws  Exception;

    Boolean sendNotificationMail(String mail, String title, String message);
}

