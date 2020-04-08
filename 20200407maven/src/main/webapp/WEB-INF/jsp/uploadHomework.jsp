<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/loginOrRegister.css">
</head>
<body>

	<div style="position:absolute;left:300px;">
		<form action="uplodHomework" method="post">
			<div class="box">
				<div class="box-input">
					作业名<input name="homeworkName" type="text">
				</div>
			</div>

			<div class="box">
				<div class="box-input">作业内容</div>
				<textarea name="homeworkContent"
					style="width: 500px; height: 300px;"></textarea>
			</div>

			<div>
				<input type="submit" class="button" value="提交">
			</div>

		</form>
	</div>



</body>
</html>