<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>나의 홈페이지</h1>

	<P>서버에서 받은 시각: ${serverTime}.</P>
	
	<p><a href="viewList">학생리스트</a>
	<p><a href="input">학생정보입력</a> <!-- anchor: 링크설정, 문자열을 클릭하면ㅁ 다른 페이지로 점프 -->
	<p><a href="search">학생정보검색</a> <!-- anchor: 링크설정, 문자열을 클릭하면ㅁ 다른 페이지로 점프 -->
	<p><a href="login">로그인</a> <!-- anchor: 링크설정, 문자열을 클릭하면ㅁ 다른 페이지로 점프 -->
	<p><a href="join">회원가입</a> <!-- anchor: 링크설정, 문자열을 클릭하면ㅁ 다른 페이지로 점프 -->
	
	

	
</body>
</html>