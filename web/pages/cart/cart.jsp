<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<script>
		$(function (){
			$("a.delete").click(function (){
				if(confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗？")){
				}
				else return false;
			});
			$("a.clear").click(function (){
				if(confirm("你确定要清空购物车吗？")){
				}
				else return false;
			});
			$("#logout").click(function (){
				if(confirm("是否确认退出登录？")){

				}
				else return false;
			});

			$(".updateCount").change(function () {

				var itemId=$(this).attr("itemId");
				var itemCount=$(this).attr("itemCount");
				var coun=this.value;
				var  name=$(this).parent().parent().find("td:first").val();
				if(confirm("你确定要将"+name+"数量修改为："+coun+"吗？")){
					location.href="${basePath}cartServlet?action=updateItem&itemId="+itemId+"&count="+coun;
				}
				else this.value=itemCount;
			});

		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp" >亲，当前购物车为空！快去选取心仪商品吧！</a></td>
				</tr>
			</c:if>
			<c:forEach items="${sessionScope.cart.items}" var="item">
			<tr>
				<td>${item.value.name}</td>
				<td><input class="updateCount" itemId="${item.value.id}" itemCount="${item.value.count}" type="text" value="${item.value.count}" style="width: 80px"></td>
				<td>${item.value.price}</td>
				<td>${item.value.totalPrice}</td>
				<td><a  class="delete" href="cartServlet?action=deleteItem&bookId=${item.value.id}">删除</a></td>
			</tr>
			</c:forEach>

			
		</table>
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a class="clear" href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="/pages/cart/checkout.jsp">去结账</a></span>
		</div>
		</c:if>


	
	</div>

	<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>