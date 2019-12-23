<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">




<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${rootPath}/css/login.css?ver=20191203001">
</head>
<body>


	<form method="POST" class="login-form">
		<h2>로그인</h2>
		<c:if test="${LOGIN_MSG == 'TRY'}">
		<h3>로그인을 해야 합니다</h3>
		</c:if>
		
		<c:if test="${LOGIN_MSG == 'NO_AUTH'}">
		<h3>작성자만이 볼 수 있음</h3>
		</c:if>
		
		<c:if test="${LOGIN_MSG == '0'}">
		<h3>로그인을 환영</h3>
		</c:if>
		
	
		
		
		
		<input type="text" name="u_id" placeholder="사용자ID">
		<input type="password" name="u_password" placeholder="패스워드">
		<button>로그인</button>
		
		<c:if test="${LOGIN_MSG == '0'}">
		<h3>회원가입</h3>
		</c:if>
	</form>
</body>
</html>