package com.tech.stack.controller;

import com.tech.stack.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhangwei on 2018/5/21.
 */
@Controller
@RequestMapping("an")
public class ANController {

    @Autowired
    private AnimalService animalService;

    @ResponseBody
    @RequestMapping("test")
    public void test() {
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
                    String sayHello = animalService.sayHello();
                    System.out.println(sayHello);
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
        //                    AnimalService as = new DogServiceImpl();
        //                    String sayHello = as.sayHello();
        //                    System.out.println(sayHello);
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
