<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>






<c:set var="rootPath" value="${pageContext.request.contextPath }"/>


<%/*

	<c:set var="새로운변수" value="${기존변수}" />
	기존변수(변수영역이 매우 길어서 불편할 경우)를 새로운 변수에 임시 할당하여
	jsp 코드 내에서 자유롭게 사용하는 방법
	
	pageContext: jsp에 설정된 전역 객체, 여러가지 정보를 담고 있음
	request: web에서 전송된 여러가지 정보가 담긴 sub객체
	contextPath: 프로젝트의 context 문자열을 담고 있는  필드 변수
	
	
	
	아래와 같은 코드가 실행
	String rootPath = pageContext.request.contextPath;
	


*/


%>




<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>나의 홈페이지</h1>

	<P>서버에서 받은 시각: ${serverTime}.</P>
	
	<p><a href="${rootPath}/viewList"> 학생리스트</a>
	<p><a href="${rootPath}/input">학생정보입력</a> <!-- anchor: 링크설정, 문자열을 클릭하면ㅁ 다른 페이지로 점프 -->
	<p><a href="${rootPath}/search">학생정보검색</a> <!-- anchor: 링크설정, 문자열을 클릭하면ㅁ 다른 페이지로 점프 -->
	<p><a href="${rootPath}/login">로그인</a> <!-- anchor: 링크설정, 문자열을 클릭하면ㅁ 다른 페이지로 점프 -->
	<p><a href="<c:url value="/join"/>">회원가입</a> <!-- anchor: 링크설정, 문자열을 클릭하면ㅁ 다른 페이지로 점프 -->
	
	

	
</body>
</html>