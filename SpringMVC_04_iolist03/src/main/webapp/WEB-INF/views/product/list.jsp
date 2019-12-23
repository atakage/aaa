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
		<p id="insert"><a href="${rootPath}/product/insert"><butto>새로등록</butto></a>
	</article>
	
	<table>
	
			<tr>	
				<th>NO</th>
				<th>상품코드</th>
				<th>상품명</th>
				<th>매입</th>
				<th>매출</th>
				<th>부가세</th>
			</tr>
			<c:choose>
				<c:when test="${empty PROLIST}">
					<tr><td colspan="5">데이터가 없음</td></tr>
				</c:when>
				<c:otherwise>
				
					<c:forEach items="${PROLIST}" var="dto" varStatus="info">
					
					<tr class="content-body" id="${dto.p_code}">
					
						<td>${info.count}</td>
						<td>${dto.p_code}</td>
						<td>${dto.p_name}</td>
						<td>${dto.p_iprice}</td>
						<td>${dto.p_oprice}</td>
						<td>${dto.p_vat}</td>
						
					</tr>
					
					</c:forEach>
				
				</c:otherwise>
			</c:choose>
	
	
	</table>
	

</section>




</body>
</html>