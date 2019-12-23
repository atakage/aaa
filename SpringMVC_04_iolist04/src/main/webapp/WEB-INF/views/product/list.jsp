<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<%@ include file="/WEB-INF/views/include/include-css.jspf" %>

<title>Insert title here</title>
</head>
<body>

<%@ include file="/WEB-INF/views/include/include-product-header.jspf" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<style>


p #insert{
	
	margin-left: 40px;
	
	
}


</style>

<script>


	$(function(){
		
		$(".content-body").click(function(e){
			
			let p_code = $(this).attr("id")
			alert(p_code)
			document.location.href="${rootPath}/product/view?p_code=" + p_code
			
		
		
	})
	
	})
</script>

<section>
	<article>
		<p id="insert"><a href="${rootPath}/product/insert"><button>새로등록</button></a>
		<%@ include file="/WEB-INF/views/product/list-body.jsp" %>
	</article>
	
	

</section>




</body>
</html>