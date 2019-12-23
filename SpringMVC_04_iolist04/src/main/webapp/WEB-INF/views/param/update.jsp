<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">




<title>Insert title here</title>
</head>
<body>

 <form method="POST">		<!--  현재 이 페이지를 열기 위한 url : /context/param/update?code=10 
 									form에 action을 별도로 지정하지 않으면 action="/context/param/update?code=10 로 자동지정"
 -->
	<label>코드</label><input name="id">
	<button>전송</button>
 </form>
</body>
</html>