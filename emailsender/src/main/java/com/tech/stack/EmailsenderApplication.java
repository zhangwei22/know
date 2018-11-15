package com.tech.stack;

import com.tech.stack.service.MailService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmailsenderApplication implements InitializingBean {

    private static List<String> toList = new ArrayList<>();

    static {
        toList.add("xxx@qq.com");
    }

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {
        System.out.println("This is main startup!");
        SpringApplication.run(EmailsenderApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("发送邮件！！！");
        mailService.sendMail(toList, "test mail subject", "hello, this is simple email.");
    }
}
