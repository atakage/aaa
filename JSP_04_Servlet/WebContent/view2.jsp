<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<%
	
	/*
					
				HelloServlet 클래스의 doGet() method에서 sendRedirect()로 보내준 데이터를 추출하여 변수에 담기
	*/
	
	
	String str_name = request.getParameter("str_name");
	String str_dept = request.getParameter("str_dept");
	String str_grade = request.getParameter("str_grade");
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>학생정보</h3>
	<p><%=str_name %></p>
	<p><%=str_dept %></p>
	<p><%=str_grade %></p>
</body>
</html>