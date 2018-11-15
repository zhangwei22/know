package com.tech.stack.service;

import java.util.List;

/**
 * Created by zhangwei on 2018/11/15.
 */
public interface MailService {
    void sendMail(List<String> toList, String subject, String content);
}
