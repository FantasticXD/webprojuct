<%--
  Created by IntelliJ IDEA.
  User: Tomato
  Date: 2021/12/6
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String basepath=request.getScheme()
            +"://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()+
            "/";
%>

<base href="<%=basepath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script src="static/jQuery-3.6.js"></script>