<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteclass").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:eq(1)").text() + "】吗");
            });
            $("a.add").click(function () {

            });
            $("#searchPageButton").click(function () {
                var pageNum = $("#pn_input").val();

                //   javascript中提供了有个location地址栏对象，他有一个属性叫href可以获取地址栏中的地址,可读可写
                location.href = "${pageScope.basePath}manager/bookServlet?action=page&pageNum=" + pageNum;

            });

        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>ID</td>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td>
                    <a href="manager/bookServlet?action=getBook&id=${book.id}&method=update&pageNum=${requestScope.page.pageNum}">修改</a>
                </td>
                <td><a class="deleteclass"
                       href="manager/bookServlet?action=delete&id=${book.id}&pageNum=${requestScope.page.pageNum}">删除</a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a class="add"
                   href="pages/manager/book_edit.jsp?method=add&pageNum=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>
    <%@include file="/pages/common/page_nav.jsp" %>

</div>

<%@include file="/pages/common/bottom.jsp" %>
</body>
</html>