package com.tech.stack.controller;

import com.tech.stack.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangwei on 2018/5/24.
 */
@Controller
@RequestMapping("autowriedVsNew")
public class AutowriedVsNewController {

    @Autowired
    private TrafficService trafficService;

    /**
     * 模拟测试Autowired注解和new，两种调用服务的性能。以及查看堆内存的情况
     */
    @ResponseBody
    @RequestMapping("concurrentTest")
    public void concurrentTest() {
        int loopCount = 10000;
        final CountDownLatch countDownLatch = new CountDownLatch(loopCount);
        long startT = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread() {
                @Override
                public void run() {
                    String autowiredRun = trafficService.run();
                    System.out.println(autowiredRun);
                    countDownLatch.countDown();
                }
            }.start();
        }
        //        for (int j = 0; j < loopCount; j++) {
        //            try {
        //                Thread.sleep(10);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            new Thread() {
        //                @Override
        //                public void run() {
        //                    TrafficService ts = new CarServiceImpl();
        //                    String newRun = ts.run();
        //                    System.out.println(newRun);
        //                    countDownLatch.countDown();
        //                }
        //            }.start();
        //        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startT));

    }
}
