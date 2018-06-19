package com.tech.stack.test;

/**
 * Created by zhangwei on 2018/6/19.
 */
public enum ResultCodeEnum {
    SUCCESS_200(200, "成功"), RESULT_300(300, "新建计划失败"), RESULT_301(301, "新建定向失败"), RESULT_302(302,
            "新建创意失败"), RESULT_303(303, "新建广告失败"), RESULT_304(304, "占用库存失败");

    private int code;
    private String msg;

    /**
     * 私有构造方法，防止被外部调用
     */
    private ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static void main(String[] args) {
        for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
            System.out.println(
                    "name:" + resultCodeEnum.name() + ", code:" + resultCodeEnum.getCode()
                            + ", msg:" + resultCodeEnum.getMsg());
        }
    }
}
