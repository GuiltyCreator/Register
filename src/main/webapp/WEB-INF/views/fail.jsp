<%--
  Created by IntelliJ IDEA.
  User: a7279
  Date: 2019/7/27
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册失败</title>
</head>
</body>
<h1>
    <!-- 当变量error存在时表示程序报错了，就只用显示报错信息 -->
    <c:if test="${error!=null}">
        登录失败<br/>
        原因：${error}
    </c:if>
    <!-- 当变量error不存在时表示程序未报错，就只用显示失败消息 -->
    <c:if test="${error==null}">
        登录失败<br/>
        原因：${msg}
    </c:if>
</h1>
</body>
</html>
