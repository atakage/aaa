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



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${rootPath}/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#btn-insert").click(function(){
	
		document.location.href="${rootPath}/memo/insert"
		
	})
	
	
})
</script>

<title>Insert title here</title>



<style>
	*{
		
		box-sizing: border-box;  													/* 무엇??????? */
		margin:0;
		padding:0;
		
	}
	
	
	html, body{
		height: 100%;
		
	}
	
	body{
		
		width:978px;
		display: flex;
		flex-flow: column wrap;
		margin: 0 auto;
	}
	
	
	header{
		
		background:#ccc;
		text-align: center;
		
	}
	
	
	footer{
	
		flex:  0 0 auto;
		background: green;
		color: white;
		text-align: center;
		padding: 0.2rem;
	}
	
	section{
		
		/* flex: 1 0 auto (화면 가득히 box를 채우기 위한 설정) */
		
		flex-grow: 1; /* 최대화 크기 */
		flex-shrink: 0;	/* 최소화 했을 때 */
		flex-basis: auto;
		background-color: #ddd;
	
	}
	
	
	section#main-body{
	
	
	flex-grow: 1; /* 최대화 크기 */
		flex-shrink: 0;	/* 최소화 했을 때 */
		flex-basis: auto;
		background-color: #ddd;
		
		display:flex;
	
	
	}
	
	
	section#main-body article{
		flex: 51;
	}
	
	section#main-body aside{
	
		border: 1px solid blue;
		background-color: white;
		padding: 16px;
		border-radius: 10px;
	}
	
	
	section#main-body ul{
		list-style: none;
		margin-left: 16px;
		
	}
	
	section#main-body li a{
	
		width: 150px;								/* a tag에 width, height를 설정하기 이해서는 display를 block or inline-block으로*/
		display: inline-block;
		border-bottom: 1px solid blue;
		padding: 10px 16px;
		text-decoration: none;
		
	}
	
	
	section#main-body li a:hover{
		background-color: #ccc;
	}
	
	
	article.list{
		border: 1px solid red;
		height:80%;
		overflow: auto;
	}
	
	
	div.b-box{
		display: flex;
		justify-content: center;
		align-items: center;
		padding: 0.8rem;
	}
	
	
	div.b-box button{
		
		background-color: orange;
		color:blue;
		font-weight: bold;
		padding: 8px 16px;
		border: 0px;
		border-radius: 5px;
	
	}
	
	
	div.b-box button:hover{
	
		background-color: #whtie;
		
	}
	
	
	div.s-box{
		
		width:100%;
		border:  1px solid blue;
		margin-bottom:5px;
	}
	
	div.s-box input{
		width:90;
		display:flex;
		justify-content: center;
		align-items: 
		
	}
	
	nav ul{
	
		list-style:none;
		background-color:blue;
		display:flex;
		color:white;
	
	}
	
	
	nav ul a{
		text-decoration: none;
		display:inline-block;
		padding:8px;
		margin:5px;
		color:inherit;
	}
	
	nav li:nth-child(2){
		margin-left:auto;
	}
	
	nav li:nth-child(4){
		margin-left:auto;
	}
	
	
</style>
</head>

<body>

<header>
<h3>나의 심플 메모장</h3>
</header>
<nav>
	<ul>
		<li><a href="${rootPath}/">홈으로</a></li>
		<li><a href="${rootPath}/">메뉴1</a></li>
		<li><a href="${rootPath}/">메뉴2</a></li>
		
		<c:if test = "${userDTO eq null}">
		<li><a href="${rootPath}/member/login">로그인</a></li>
		<li><a href="${rootPath}/user/join">회원가입</a></li>
		</c:if>
		
		<c:if test = "${userDTO != null}">
		<li><a href="${rootPath}/member/logout">로그아웃</a></li>
		<li><a href="${rootPath}/member/join">${userDTO.u_name }</a></li>
		</c:if>
	</ul>
</nav>


<section id="main-body">

	<article>
		<div class="s-box">
			<form>
				<input type="text" name="search">
			</form>
		</div>
			<article class="list">
			
				<%@ include file="/WEB-INF/views/list.jsp"%>
				
			</article>
			
			<div class="b-box">
				<button id="btn-insert">메모작성</button>
			</div>
	</article>

<aside>
	<ul>
		<li><a href="">오늘 할 일</a></li>
		<li><a href="">약속</a></li>
		<li><a href="">중요메모</a></li>
		<li><a href="${rootPath}/html/hello.html">hello</a></li>
		<li><a href="${rootPath}/images/readme.txt">readme</a></li>			<!--  컨트롤러에 리퀘스트매핑 value="images/readme"가 되어있으면? -->
	</ul>

</aside>
</section>



<footer>
	<address>CopyRight &copy; callor@callor.com</address>
</footer>

</body>
</html>