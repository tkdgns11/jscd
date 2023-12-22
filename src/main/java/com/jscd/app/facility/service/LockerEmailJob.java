package com.jscd.app.facility.service;

import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

// 사용기간이 3일남은 락커 정보를 가져와서 자정에 사용자에게 이메일 보내주는 스케줄 등록
@Component
public class LockerEmailJob implements Job {

    @Autowired
   LockerService lockerService;

    @Autowired
    JavaMailSenderImpl mailSender;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            List<Map<String, Object>> list = lockerService.lockerAlert();
            System.out.println("list = " + list);
            alertEmail(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //이메일 보낼 양식
    public void alertEmail(List<Map<String, Object>> list) {

        for (Map<String, Object> map : list) {
            String setFrom = "jyh931229@gmail.com";
            String toMail = map.get("email").toString();
            String title = "정석코딩 사물함 사용기간 종료 3일전 안내";
            String content = map.get("name").toString() + "님 안녕하세요. 귀하의 " + (map.get("lockerCode").toString().equals("01") ? "4층 " : "5층 ") + map.get("lockerID").toString() + "번 사물함 사용기간이 3일 남았습니다.";
            alertMailSend(setFrom, toMail, title, content);
        }
    }

    //이메일 전송 메소드
    public void alertMailSend(String setFrom, String toMail, String title, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content);
            mailSender.send(message);
            System.out.println("메일 전송 완료");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}