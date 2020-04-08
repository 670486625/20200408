<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/menu.css">
<link rel="stylesheet" href="../css/loginOrRegister.css">
<script src="../js/menu.js"></script>

</head>
<body>



	<!-- ======================================= -->
	<!-- ======================================= -->
	<!-- 左侧功能列表 -->
	<div class="menu">

		<div>
			<p onclick="accordion(1)">登陆</p>
			<ul id="ul1">
				<li><a href="../jsp/login.jsp">登陆</a></li>
			</ul>
		</div>
		<div>
			<p onclick="accordion(2)">上传作业</p>
			<ul id="ul2">
				<li><a href="../jsp/uploadHomework.jsp">上传作业</a></li>
			</ul>
		</div>
		<div>
			<p onclick="accordion(3)">提交作业</p>
			<ul id="ul3">
				<li><a href="submitHomework">上传作业</a></li>
			</ul>
		</div>
		<div>
			<p onclick="accordion(4)">查看作业</p>
			<ul id="ul4">
				<li><a href="checkHomework">查看作业</a></li>
			</ul>
		</div>


	</div>



</body>
</html>