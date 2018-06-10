<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/sys/frontendStyle/js/jquery.js"></script>
<script type="text/javascript" src="/sys/frontendStyle/js/page_common.js"></script>
<link href="/sys/frontendStyle/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/sys/frontendStyle/css/index_1.css" />
	<link href="/sys/frontendStyle/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->
					<c:forEach items="${list}" var="food">
						<li>
							<dl>
								<dt>
									<a href="/CaixixiServlet?id=${food.id}">
										<img width="214px" height="145px" src='${food.img}' />
									</a>
								</dt>
								<dd class="f1">
									<a href="/CaixixiServlet?id=${food.id}">${food.foodName}</a>
								</dd>
								<dd class="f2">
									<a href="/CaixixiServlet?id=${food.id}">&yen;${food.price}</a>
								</dd>
							</dl>
						</li>
					</c:forEach>
					

					
				</ul>
			</div>
			
			<!-- 底部分页导航条div -->
			<div id="foot">
				
					
					
						<span
							style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
							<span style="font-weight:bold">&lt;&lt;</span>
						</span>
					
				
				<div id="btn">
					<ul>
						<!-- 参看 百度, 谷歌是 左 5 右 4 -->
						
							<li><a
								href="#">1</a></li>
						
							<li><a
								href="#">2</a></li>
						
					</ul>
				</div>
				
					
						<span style="float:right; line-height:53px; margin-right:10px;  ">
							<a
							href="#"
							style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a>
						</span>
					
					
				
			</div>
			
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="clientOrderList.html">
							<img src="style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
					
						<li>
							<a href="caidan.html">粤菜</a>
						</li>
					
						<li>
							<a href="chuancai.html">川菜</a>
						</li>
					
						<li>
							<a href="chuancai.html">湘菜</a>
						</li>
					
						<li>
							<a href="chuancai.html">东北菜</a>
						</li>
					
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="#" method="post">
					<table width="166px">
						<tr>
							<td>
								<input type="text" id="dish_name" name="foodName" class="select_value" /> 
								<input type="hidden" value="selectFood" name="method">
							</td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td>
								<a href="#">
									<img src="/sys/frontendStyle/images/look.gif" />
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
