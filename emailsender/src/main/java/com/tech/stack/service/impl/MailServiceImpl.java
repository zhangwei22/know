package com.tech.stack.service.impl;

import com.tech.stack.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhangwei on 2018/11/15.
 */
@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendMail(List<String> toList, String subject, String content) {
        System.out.println("发送邮件初始化……");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        System.out.println("准备发送邮件……");
        try {
            for (String to : toList) {
                simpleMailMessage.setTo(to);
                javaMailSender.send(simpleMailMessage);
                System.out.println(to + "邮件发送成功！！！");
            }
        } catch (Exception e) {
            System.out.println("发送邮件时发生异常-_-" + e);
        }
    }
}
