package com.prode.service.impl;

import com.prode.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class MessengerServiceImpl implements MessengerService {

    @Autowired
    @Qualifier("mailSender")
    private JavaMailSender javaMailSender;


    @Value("${workplace.api}")
    private String apiWorkplace;
    @Value("${workplace.idgroup}")
    private String idGroupWorkplace;
    @Value("${workplace.token}")
    private String tokenWorkplace;


    @Value("${mail.get.notification}")
    private String notificationEmail;

    @Override
    public void sendNotificationWorkplace(String urlPost, String message)throws  Exception  {
        String url = apiWorkplace + idGroupWorkplace + "/feed" + tokenWorkplace;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        String urlParameters = "message=" + message+ "&" + "link=" + urlPost;
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
    }


    @Override
    public void sendNotificationMail(String title, String message) {
        javaMailSender.send(buildEmail(title, message));
    }


    private SimpleMailMessage buildEmail(String title, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(notificationEmail);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(message);
        return simpleMailMessage;
    }

}

