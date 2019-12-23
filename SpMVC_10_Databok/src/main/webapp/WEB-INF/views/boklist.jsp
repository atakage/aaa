<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<<c:set var="rootPath" value="${pageContext.request.contextPath }"></c:set>

<style>

table.bok-list{
	border-collapse:collapse;
	border-spacing: 0;
	width: 95%;
	margin: 10px auto;
	border: 1px solid green;
	table-layout: fixed;
}

table.bok-list tr, table.bok-list th{
	border: 1px solid #ddd;
}

table.bok-list th{
	text-align: left;
}

table.bok-list th, table.bok-list td{
	padding:8px;
	vertical-align: top;
	white-space: nowrap;

}

table.bok-list td{
	overflow: hidden;
	text-overflow: ellipsis;
	border:none;
	
}

table.bok-list tr{
	background-color: gray;
}

tr.bok-body:nth-child(even){

	background-color: #ccc;
	
}

tr.bok-body:nth-child(odd){

	background-color: #fff;
	
}

tr.bok-body:hover{
	backgroud-color: #ddd;
	cursor: pointer;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>

$(function(){
	
	$("tr.bok-body").click(function(){
		
		
		let servId = $(this).attr("data-id")
		
		document.location.href="${rootPath}/detail?id=" + servId
		
	})
	
	
})

</script>


<body>



	<Table class="bok-list">
		<colgroup>
		
			<col width="100px">
			<col width="120px">
			<col width="100px">
			
			<col width="80px">
			<col width="300px">

		
			
		</colgroup>
		
		<tr>
		
		
	
		<th>서비스 등록일</th>
		<th>서비스명</th>
		<th>소관부처명</th>
		<th>소관조직명</th>
		<th>조회수</th>
		<th>서비스 요약</th>
		
		
		
		</tr>
		
		
		<c:choose>
			<c:when test="${empty BOKLIST}">
				<tr><td colspan="7">조회된 데이터가 없음</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${BOKLIST}" var="bok" varStatus="index">
				
				
					<tr class="bok-body" data-id="${bok.servId}">
					
						
						<td>${bok.svcfrstRegTs}</td>
						<td>${bok.servNm}</td>
						<td>${bok.jurMnofNm}</td>
						<td>${bok.jurOrgNm}</td>
						<td>${bok.inqNum}</td>
						<td>${bok.servDgst}</td>
					
						
						
					
							
					</tr>
					
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		
		
	
	
	
	</Table>

</body>
</html>