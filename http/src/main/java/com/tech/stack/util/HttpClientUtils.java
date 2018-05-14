package com.tech.stack.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangwei on 2018/5/14.
 */
public class HttpClientUtils {

    /**
     * get请求
     *
     * @param strUrl
     * @param map
     * @return string
     */
    public static String sendGet(String strUrl, Map map) throws IOException {
        String strtTotalURL = "";
        StringBuffer sb = new StringBuffer();
        if (strtTotalURL.indexOf("?") == -1) {
            strtTotalURL = strUrl + "?" + getUrl(map);
        } else {
            strtTotalURL = strUrl + "&" + getUrl(map);
        }
        URL url = new URL(strtTotalURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setUseCaches(false);
        HttpURLConnection.setFollowRedirects(true);
        BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String tmp = null;
        while ((tmp = bin.readLine()) != null) {
            sb.append(tmp);
        }
        bin.close();
        return sb.toString();
    }

    /**
     * post请求
     *
     * @param strUrl
     * @param map
     * @return string
     */
    public static String sendPost(String strUrl, Map map) throws IOException {
        String content = "";
        StringBuffer sb = new StringBuffer();
        content = getUrl(map);
        String totalURL = null;
        if (strUrl.indexOf("?") == -1) {
            totalURL = strUrl + "?" + content;
        } else {
            totalURL = strUrl + "&" + content;
        }
        URL url = new URL(strUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setAllowUserInteraction(false);
        con.setUseCaches(false);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=GBK");
        BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
        bout.write(content);
        bout.flush();
        bout.close();
        BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String tmp = null;
        while ((tmp = bin.readLine()) != null) {
            sb.append(tmp);
        }

        bin.close();
        return sb.toString();
    }

    /**
     * 带cookie的post请求
     */
    public static String sendPost(String strUrl, Map map, String cookies) throws IOException {
        String content = "";
        StringBuffer sb = new StringBuffer();
        content = getUrl(map);
        String totalURL = null;
        if (strUrl.indexOf("?") == -1) {
            totalURL = strUrl + "?" + content;
        } else {
            totalURL = strUrl + "&" + content;
        }
        URL url = new URL(strUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setAllowUserInteraction(false);
        con.setUseCaches(false);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=GBK");
        con.setRequestProperty("Cookie", cookies);
        BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
        bout.write(content);
        bout.flush();
        bout.close();
        BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String tmp = null;
        while ((tmp = bin.readLine()) != null) {
            sb.append(tmp);
        }
        bin.close();
        return sb.toString();
    }

    /**
     * 获取当前http请求的cookie
     */
    public static String getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        StringBuffer tmpcookies = new StringBuffer();
        for (Cookie c : cookies) {
            tmpcookies.append(c.getName()).append("=").append(c.getValue()).append(";");
        }
        return tmpcookies.toString();
    }

    private static String getUrl(Map map) {
        if ((null == map) || (map.keySet().size() == 0)) {
            return "";
        }
        StringBuffer url = new StringBuffer();
        Set keys = map.keySet();
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            String key = String.valueOf(i.next());
            if (map.containsKey(key)) {
                Object val = map.get(key);
                String str = (val != null) ? val.toString() : "";
                try {
                    str = URLEncoder.encode(str, "GBK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                url.append(key).append("=").append(str).append("&");
            }
        }
        String strURL = "";
        strURL = url.toString();
        if ("&".equals("" + strURL.charAt(strURL.length() - 1))) {
            strURL = strURL.substring(0, strURL.length() - 1);
        }
        return strURL;
    }

}
