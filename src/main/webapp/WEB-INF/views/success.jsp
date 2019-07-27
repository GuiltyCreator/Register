<%--
  Created by IntelliJ IDEA.
  User: a7279
  Date: 2019/7/27
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册成功</title>
</head>
<body>
<h2>用户注册信息</h2>
<hr>
<p>
    用户名称：${user.username}
</p>
<p>
    登录密码：${user.password}
</p>
<p>
    重复密码：${user.repeatPassword}
</p>
<p>
    电子邮箱：${user.email}
</p>
<p>
    性别：${user.gender}
</p>
<p>
    职业：${user.profession}
</p>
<p>
    爱好：${user.hobbyString}
</p>
</body>
</html>
