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
				<th>作业编号</th>
				<th>作业名</th>
				<th>作业内容</th>
				<th>作业提交</th>
			</tr>
			<%
		int[] homeworkNumSet = (int[]) request.getAttribute("homeworkNumSet");
		String[] homeworkNameSet = (String[]) request.getAttribute("homeworkNameSet");
		String[] homeworkContentSet = (String[]) request.getAttribute("homeworkContentSet");

		int index = 0;
		
		
		while(true){
			
			try{
				if(homeworkNameSet[index].equals(""))break;
			}catch(Exception e){
				break;
			}
			

			out.println("<tr><td>" + homeworkNumSet[index] + "</td>" 
						+ "<td>" + homeworkNameSet[index] + "</td>"
						+ "<td>" + homeworkContentSet[index] + "</td>"
						+"<td><a href='../jsp/submitHomework2.jsp?id="+homeworkNumSet[index]+"'>提交</a></td>"
					+ "</tr>");
			index++;
		}
	%>
			
		</table>

	

</body>
</html>