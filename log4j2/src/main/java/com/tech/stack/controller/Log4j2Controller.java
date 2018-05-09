package com.tech.stack.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangwei on 2018/5/9.
 */
@Controller
@RequestMapping("log4j2")
public class Log4j2Controller {

    static final Logger logger = LogManager.getLogger(Log4j2Controller.class);

    public static void main(String[] args) {
        //由于配置console的日志级别是info级别，这里的debug日志不会在控制台打印
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
    }

}
