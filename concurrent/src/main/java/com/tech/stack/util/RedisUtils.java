package com.tech.stack.util;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by zhangwei on 2018/5/4.
 * <p>
 * 用map来模拟redis操作
 */
public class RedisUtils {
    public static Map<String, String> tokenMap;

    static {
        tokenMap = new Hashtable();
    }
}
