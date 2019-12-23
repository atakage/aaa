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


<style>
	
	*{
		padding:0;
		margin: 0;
		box-sizing: border-box;
	
	}
	
	bod{
	
		width:95%;
		margin: 0 auto;
	
	}
	
	header{
		background-color: rgba(0,255,0,0.5);
		padding: 0.8rem;
	}
	
	article.bok-body{
		
		display: flex;
		padding: 5px;
		
	
	}
	
	section#bok-search{
	
		flex: 1 0 500px;
		
	
	}


</style>


</head>
<body>


<header>

	<h3>복지로 서비스</h3>

</header>


<article class="bok-body">

<section class=" bok-body">
<%@ include file="/WEB-INF/views/boksearch.jsp" %>
</section>
<section id="bok-list">
	<%@ include file="/WEB-INF/views/boklist.jsp" %>
</section>

<section id="bok-temp">

</section>
</article>
</body>
</html>