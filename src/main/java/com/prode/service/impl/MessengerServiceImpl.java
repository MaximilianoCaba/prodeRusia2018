package com.prode.service.impl;

import com.prode.service.MessengerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

@Service
public class MessengerServiceImpl implements MessengerService {


    @Value("${workplace.api}")
    private String apiWorkplace;
    @Value("${workplace.idgroup}")
    private String idGroupWorkplace;
    @Value("${workplace.token}")
    private String tokenWorkplace;

    @Value("${mail.username}")
    private String username;
    @Value("${mail.password}")
    private String password;
    @Value("${mail.port}")
    private String port;
    @Value("${mail.host}")
    private String host;
    @Value("${mail.socketfactory}")
    private String socketFactory;
    @Value("${mail.auth}")
    private String auth;

    @Override
    public Boolean sendNotificationWorkplace(String urlPost, String data)throws  Exception  {
        // TODO MIGRAR A REST_TEMPLATE
        String url = apiWorkplace + idGroupWorkplace + "/feed" + tokenWorkplace;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        String urlParameters = "message=" + data+ "&" + "link=" + urlPost;
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
        return true;
    }


    @Override
    public Boolean sendNotificationMail(String mail, String title, String message) {
        Properties mailServerProperties;
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.host", host);
        mailServerProperties.put("mail.smtp.socketFactory.port", port);
        mailServerProperties.put("mail.smtp.socketFactory.class", socketFactory);
        mailServerProperties.put("mail.smtp.auth", auth);
        mailServerProperties.put("mail.smtp.port", port);

        try {
            javax.mail.Session getMailSession = Session.getDefaultInstance(
                    mailServerProperties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            javax.mail.internet.MimeMessage generateMailMessage;
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
            generateMailMessage.setSubject(title);
            String msg = "<h1>Aviso de la app Prode Rusia2018</h1>";
            msg += message;
            generateMailMessage.setContent(msg, "text/html");
            Transport.send(generateMailMessage);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}

