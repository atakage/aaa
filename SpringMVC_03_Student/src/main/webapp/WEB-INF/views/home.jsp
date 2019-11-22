<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<html>
<head>
<title>Home</title>
<style type="text/css">
header {
	
	margin: 0;
	padding: 1rem;
	color: black;
}





ol {
	
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
	background-color: slategray;
}

h3 {
	font-size: 2rem;
}

ol a {
	display: block;
	text-decoration: none;
	color: black;
	padding: 14px 16px
}

ol a:hover {
	background-color: white;
	color: blue;
}

footer {
	background-color: #777;
	padding: 10px;
	text-align: center;
	color: white;
}
</style>
</head>
<body>
	<header>
		<h3>학생정보 관리</h3>
	</header>
	
	<ol>
		<!--  ul: unordered List -->
		<!--  ol: ordered list -->
		<li><a href="${rootPath}/student/list">학생리스트</a></li>
		<!--  list item-->
		<li><a href="${rootPath}/student/search">학생검색</a></li>
		<li class="join&log"><a href="#">로그인</a></li>
		<li class="join&log"><a href="#">회원가입</a></li>

	</ol>
	
	<div>
	
	
	ㄹㅇㄶㄴㅇㅀ
	
	ㄴㅇㅎㄴㅇㅎㄴㅇㅎ
	ㄴㅇㅎㅇㄶ
	
	</div>
	
	
	

	
	<footer>
		<p>Footer</p>
	</footer>

</body>
</html>
