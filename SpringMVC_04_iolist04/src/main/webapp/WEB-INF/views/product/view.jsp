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


<%@ include file="/WEB-INF/views/include/include-css.jspf" %>

<title>Insert title here</title>
</head>
<body>


	<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<script>
	
	$(function(){
		
		
		
		$(".btn-update").click(function(){
			
			let p_code = "${PRO_DTO.p_code}"
			
				document.location.href= "${rootPath}/product/update?id=${PRO_DTO.p_code}"
			
		})
	
	
	
		$(".btn-delete").click(function(){
		
			
			let msg = "상품코드: ${PRO_DTO.p_code}  삭제할까여?"
					
			let p_code = "${PRO_DTO.p_code}"
			if(confirm(msg)){
				document.location.href = "${rootPath}/product/delete?id=${PRO_DTO.p_code}"
			}
		
		
		})
	
	})
	
	
</script>


<style>

p #insert{
	
	margin-left: 40px;
}


th{
	background-color: #ccc;
	text-align: right;
}

td{
	background-color: #ddd;
}

div.btn-box{

	display:flex;
	width:90%;
	margin: 10px auto;
	justify-content: center;
	align-items: center;
	padding: 10px;
	
}

button{

	border-radius: 10px;
	outline: none;
	margin-right: 10px;
	padding:10px 20px;

}

button:hover{
	background-color: #ddd;
	color:black;
	cursor: pointer;
}

.btn-update{
	
	background-color:blue;
	color:white;
	border: 0px;
	border-radius: 3px;
}

.btn-delete{
	
	background-color: orange;
	color:white;
}

</style>

<script>
	$(function(){
	})
</script>


<section>
	<table>
		<tr>
			<th>상품코드</th><td>${PRO_DTO.p_code}</td>
			<th>상품명</th><td>${PRO_DTO.p_name}</td>
		</tr>
		
		<tr>
			<th>매입</th><td>${PRO_DTO.p_iprice}</td>
			<th>매출</th><td>${PRO_DTO.p_oprice}</td>
		</tr>
		
		<tr>
			<th>부가세</th><td colspan="3">${PRO_DTO.p_vat}</td>
		</tr>
			<tr>
				
				<td colspan="4" >
				<div class="btn-box" >
					<button class="btn-update">수정</button>
					<button class="btn-delete">삭제</button>
					
					</div>
				</td>
			</tr>
	</table>
</section>



</body>
</html>