<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>index</title>
</head>
<body>
<div>
    <div>
        <p2>这是一个jsp欢迎页</p2>
        <div>
            <table>
                <thead>
                <th>测试测试兄dei</th>
                </thead>
                <tbody>
                <tr>
                    <td>姓名：${person.name}</td>
                </tr>
                <tr>
                    <td>性别：${person.sex}</td>
                </tr>
                <tr>
                    <td>年龄：${person.age}</td>
                </tr>
                <tr>
                    <td>工种：${person.job}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <br>
</div>
</body>
</html>
