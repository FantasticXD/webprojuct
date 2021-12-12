<%--
  Created by IntelliJ IDEA.
  User: Tomato
  Date: 2021/12/7
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
  <c:if test="${requestScope.page.pageNum>1}">
    <a href="${requestScope.page.url}1">首页</a>
    <a href="${requestScope.page.url}${requestScope.page.pageNum-1}">上一页</a>
  </c:if>
  <c:if test="${requestScope.page.pageNum>3}">
    <a href="${requestScope.page.url}${requestScope.page.pageNum-2}">${requestScope.page.pageNum-2}</a>
  </c:if>
  【${requestScope.page.pageNum}】
  <c:if test="${requestScope.page.pageNum<requestScope.page.pageTotal-2}">
    <a href="${requestScope.page.url}${requestScope.page.pageNum+2}">${requestScope.page.pageNum+2}</a>
  </c:if>
  <c:if test="${requestScope.page.pageNum<requestScope.page.pageTotal}">
    <a href="${requestScope.page.url}${requestScope.page.pageNum+1}">下一页</a>
    <a href="${requestScope.page.url}${requestScope.page.pageTotal}">末页</a>
  </c:if>
  共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
  到第<input value="${requestScope.page.pageNum}" name="pn" id="pn_input"/>页
  <input id="searchPageButton" type="button" value="确定">
</div>
