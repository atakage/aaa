<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String strName = "대한민국";
	String strNum1 = request.getParameter("num1"); // getParameter로 추출하는 모든 값은 무조건 문자열로 받아야 함
	String strNum2 = request.getParameter("num2");
	
	
	int intNum1 = Integer.valueOf(strNum1);
	int intNum2 = Integer.valueOf(strNum2);
	
	int sum = intNum1 + intNum2;

/*
			request: jsp 내에서만 사용가능한 java의 singletone static 객체
						jsp 파일이 만들어지면서 객체 생성, 초기화까지 완료됨
						엡 페이지에서 query(질의어)를 보내면 그 정보를 받을 때 사용하는 객체
*/
	strName = request.getParameter("strName");
%>
<html>
<head>
<meta charset="UTF-8">
<title>나의 페이지</title>
</head>
<body>
<h3>나의 페이지</h3>
<p><%=intNum1 %> + <%=intNum2 %> = <%=sum %></p>

<p>나의 페이지에 오신 것을 환영</p>
<p>나의 페이지는 JSP 테스트를 위해서 작성하고 있습니다</p>
<p>웹 페이지에서는 빈칸의 개수에 관계없이 1개만 빈칸으로 인식하고<br/>
나머지는 모두 무시</p>
<p>나는 										우리나라</p>
<p>나는 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 대한민국</p>					<!-- &...; 형식의 문자열은 특수코드 문자열 -->
<p><%=strName %></p>

<!-- &nbsp; 는 웹페이지에 임의 빈칸을 개수만큼 표기 
	
	
	&copy; 는 CopyRight 특수코드



-->
<p>Copy Right &copy; callor@callor.com</p>
</body>
</html>