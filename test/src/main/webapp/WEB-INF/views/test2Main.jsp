<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Page Title</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen' href='test2.css'>


<c:set var="rootPath" value="${pageContext.request.contextPath }" />

</head>
<body>



	<div class="header">
		<p>
			<a href="#">아아</a>
		</p>
	</div>


	<ul>

		<li class="navMenu1"><a href="test2login.html">로그인</a></li>
		<li class="navMenu1"><a href="#">가입</a></li>
		<li class="navMenu2"><a href="#">공지</a></li>
		<li class="navMenu2"><a href="#">뉴스</a></li>

		<li id="navMenu2SocialG" class="navMenu2"><a href="#">대상별</a>

			<div class="socialDrop">

				<a href="#">청년</a> <a href="#">여성</a> <a href="#">중장년</a> <a
					href="#">외국인</a> <a href="#">장애인</a>

			</div></li>


		<li class="navMenu2"><a href="#">지역별</a></li>
		<li class="navMenu2"><a href="#">사이트소개</a></li>
		<li class="navMenu2"><a href="#">정책자료실</a></li>

	</ul>


	<div class="columnSide">


		<a href="#">사이트소개</a> <a href="#">공지사항</a> <a href="#">뉴스</a>


	</div>





	<div class="contentTitle">
		<a>ddddddddddddddddddddd</a>
	</div>






	<div class="footer">

		<a>footer</a>

	</div>





</body>
</html>