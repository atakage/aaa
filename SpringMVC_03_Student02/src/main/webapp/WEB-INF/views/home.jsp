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

<%@ include file="/WEB-INF/views/include/include-title.jspf" %>









</head>
<body>


<%@ include file="/WEB-INF/views/include/include-header.jspf" %>

	
	
	
	
	
	<div class="side">
	
	<a href="">m</a>
	<a href="">m2</a>
	<a href="">m3</a>
	<a href="">m4</a>
	
	</div>
	
	
	<div class="main">
	
	<c:choose>
	
	<c:when test="${BODY == 'STUDENT-LIST'}">
		<p>여기는 학생 리스트</p>
	</c:when>
	<c:when test="${BODY == 'DEPT-LIST'}">
		<p>여기는 학과 정보 페이지</p>
	</c:when>
	<c:when test="${BODY == 'LOGIN'}">
		<p>여기는 로그인 페이지</p>
	</c:when>
	<c:when test="${BODY == 'JOIN'}">
		<p>회원가입 페이지</p>
	</c:when>
	
	<c:otherwise>
		
	</c:otherwise>
	
	</c:choose>
	
	
	
	</div>




</body>
</html>