<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="/WEB-INF/views/include/include-title.jspf"%>


<style>
table {
	border-collapse: collapse;
	/* table을 표시할 때 table의 바깥쪽 라인과 각 컬럼의 라인간 간격을 없애고자 할 때 */
	border-spacing: 0; /* 표를 실선모양으로 외부 라인 설정 */
	width: 90%;
	border: 1px solid blue;
	margin: 20px auto; /* top, bottom 여백을 20픽셀로 하고 left와 right 여백은 자동으로
									좌우 중앙에 물체(box)를 위치하라
	*/
}

table td, table th {
	padding: 8px;
	vertical-align: top;
}

table th {
	text-align: left;
}

table tr:nth-child(odd) {
	background-color: #fff;
}

table tr:nth-child(even) {
	background-color: #ccc;
}

table tr:hover {
	background-color: gray;
}
</style>
</head>






<body>




	<table>

		<tr>

			<th>번호</th>
			<th>이름</th>
			<th>학과</th>
			<th>학년</th>
			<th>전화번호</th>

		</tr>
		<c:choose>

			<c:when test="${STDLIST == NULL}">

				<tr>
					<td colspan="5">데이터가 없음</td>
				</tr>

			</c:when>

			<c:otherwise>

				<c:forEach items="${STDLIST}" var="dto">

					<tr>
						<td>${dto.st_num}</td>
						<td>${dto.st_name}</td>
						<td>${dto.st_dept}</td>
						<td>${dto.st_grade}</td>
						<td>${dto.st_tel}</td>
					<tr>
				</c:forEach>

			</c:otherwise>

		</c:choose>






	</table>



	<c:forEach items="${STDLIST}" var="dto">


		<p>${dto.st_num}${dto.st_name}${dto.st_dept}${dto.st_grade}
	</c:forEach>


</body>
</html>