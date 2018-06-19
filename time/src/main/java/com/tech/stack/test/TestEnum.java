package com.tech.stack.test;

/**
 * Created by zhangwei on 2018/6/19.
 */
public enum TestEnum {
    SUCCESS_200("成功", 200, "S"), RESULT_300("新建计划失败", 300, "M"), RESULT_301("新建定向失败", 301,
            "L"), RESULT_302("新建创意失败", 302, "X"), RESULT_303("新建广告失败", 303, "XX"), RESULT_304(
            "占用库存失败", 304, "XXX");

    private String msg;
    private int code;
    private String size;

    private TestEnum(String msg, int code, String size) {
        this.msg = msg;
        this.code = code;
        this.size = size;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public String getSize() {
        return size;
    }

    public static void main(String[] args) {
        for (TestEnum testEnum : TestEnum.values()) {
            System.out.println(
                    "name:" + testEnum.name() + ", msg:" + testEnum.getMsg() + ", code:" + testEnum
                            .getCode() + ", size:" + testEnum.getSize());
        }

        System.out.println(TestEnum.RESULT_300.getSize());
        System.out.println(TestEnum.RESULT_304.getCode());
        System.out.println(TestEnum.SUCCESS_200.getMsg());
    }
}
