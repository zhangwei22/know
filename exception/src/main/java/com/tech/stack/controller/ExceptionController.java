package com.tech.stack.controller;

import com.tech.stack.entity.TestBean;
import com.tech.stack.exception.MyException;
import com.tech.stack.exception.MyRuntimeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangwei on 2018/5/21.
 */
@RestController
@RequestMapping("exception")
public class ExceptionController {

    @GetMapping("/{id}")
    public String testException(@PathVariable(name = "id") Integer id) throws MyException {
        if (id == 1) {
            throw new MyException("id不能为1");
        } else if (id == 2) {
            throw new MyRuntimeException("id不能为2");
        }

        System.out.println("enter id=" + id);
        return "SUCCESS!";
    }

    /**
     * 如果需要分类处理，则需要细分子异常
     * 否则可以直接抛Exception
     */
    public static void main(String[] args) {
        try {
            //            double res = 10 / 0;
            TestBean testBean = null;
            String name = testBean.getName();
        } catch (ArithmeticException e0) {
            e0.printStackTrace();
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
