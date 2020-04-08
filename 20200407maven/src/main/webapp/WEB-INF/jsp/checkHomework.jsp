<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/table.css">
</head>
<body>

<table class="table"  width="100%" border="0">
			<tr>
				<th>列表编号</th>
				<th>作业编号</th>
				<th>学生姓名</th>
				<th>作业内容</th>
			</tr>
			<%
		int[] homeworkListNumSet = (int[]) request.getAttribute("homeworkListNumSet");
		int[] homeworkNumSet = (int[]) request.getAttribute("homeworkNumSet");
		String[] studentNameSet = (String[]) request.getAttribute("studentNameSet");
		String[] homeworkContentSet = (String[]) request.getAttribute("homeworkContentSet");

		int index = 0;
		
		
		while(true){
			
			try{
				if(studentNameSet[index].equals(""))break;
			}catch(Exception e){
				break;
			}
			

			out.println("<tr><td>" + homeworkListNumSet[index] + "</td>" 
						+ "<td>" + homeworkNumSet[index] + "</td>"
						+ "<td>" + studentNameSet[index] + "</td>"
						+ "<td>" + homeworkContentSet[index] + "</td>"
						+ "</tr>");
			index++;
		}
	%>
			
		</table>

</body>
</html>