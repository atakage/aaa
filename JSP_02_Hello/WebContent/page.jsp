<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    String strName = request.getParameter("strName");	// 웹브라우저에서 query로 전달받은 변수(strName) 값ㅇ르 추출하여 변수 strName에 저장
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>나의 정보</h3>
<p>나는 (<%=strName %>)입니다
<p><% out.write("대한민국"); %>
<p><% out.write(30*40); %>
<p><% 

int sum = 30 + 40;
out.write(sum);


%>

</body>
</html>