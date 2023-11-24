package com.jscd.app.member.dto;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mailSender {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("wjdtnrkd0203@gmail.com", "nkny zwvw aczp fcgx");
            }
        });

        String receiver = "wjdtnrkd0203@naver.com"; // 메일 받을 주소
        String title = "테스트 메일입니다.";
        String content = "<h2 style='color:blue'>안녕하세요</h2>";
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("wjdtnrkd0203@gmail.com", "관리자", "utf-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(title);
            message.setContent(content, "text/html; charset=utf-8");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}