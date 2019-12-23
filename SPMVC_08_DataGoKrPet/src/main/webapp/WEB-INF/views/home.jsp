<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>


	$(function(){
	
		$("#s_cat").change(function(){
		
			$("form").submit()
			
			
		})
		
		
		$("#s_text").on("search", function(){				// type="serach"인 input bodx에서 clear버튼을 눌렀을 때 발생하는 이벤트를 catch하여 처리가능
			
													// clear된 상태 명시한 부분 ㅇㄷ?
																		
		
			
			$("form").submit()
		})
		
		
		
		
		
		
		
		
		
		
		
		
	})
	
	


</script>


<title>Insert title here</title>

<style>

	header{
		background:rgba(0,255,0,03.);
		color:blue;
		text-align: center;
		padding:0.5rem;
		text-transform: uppercase;
	}
	
	nav{
		
		background:green;
	
	}
	
	nav input{
		
		width: 300px;
		padding: 8px;
		margin: 10px;
		border: 1px solid orange;
		border-radius: 20px;
		position:relative;
	}
	
	nav select{
		
		width: 300px;
		padding: 8px, 0.5rem;
		border: 1px solid orange;
		background: url('${rootPath}/images/arrow.png') no-repeat 95% 50%;
		background-color: white;
		appearance: none;
		-moz-appearance: none;
		-webkit-appearance: none;
	
	}
	
	
	nav input:hover:after{
		content: '동물병원 이름이나 주소 입력';
		position: absolute;
		top: 20px;
		left: 30px;
	}

</style>
</head>
<body>



<header>


	<h3>my pet life</h3>
	


</header>
<nav>

	<form:form modelAttribute="searchVO" method="GET">		<!-- 컨트롤러에 명시된 modelAttribute 다시 쓰는 이유? form 형태 달라서? -->
	<form:select path="s_cat">
		<form:option value="hs">병원명</form:option>
		<form:option value="addr">주소</form:option>
	</form:select>

		<form:input type="search" path="s_text" placeholder="검색어를 입력한 후 Enter..."/>
		
		
	</form:form>


	<table>
		
		<tr>
			<td>번호</td>
			<td>이름</td>
		</tr>
	
	</table>


</nav>

<section>

	<table>
		<tr>
			<th>동물병원모음</th>
			<th>동물병원의 이름</th>
			<th>도로명주소</th>
			<th>지번주소</th>
			<th>대행업소의 연락처</th>
			<th>위도</th>
			<th>경도</th>
			<th>데이터기준일</th>
		<tr>
		<c:choose>
			<c:when test="${empty HLIST}">
				<tr><td colspan="7">데이터가 없음</td>
			</c:when>
			
			<c:otherwise>
			
				<c:forEach items="${HLIST}" var="hs" varStatus="index">				<!-- varstatus 무엇? -->
				
					
					<tr>
						<td>${hs.apiDongName}</td>										<!--  hs 안 붙이면? or HLIST.apiDongName ?-->
						<td>${hs.apiNewAddress}</td>
						<td>${hs.apiOldAddress}</td>
						<td>${hs.apiTel}</td>
						<td>${hs.apiLat}</td>
						<td>${hs.apiLng}</td>
						<td>${hs.apiRegDate}</td>
					</tr>
					
				</c:forEach>
			
			</c:otherwise>
		</c:choose>			
			
			
				
	</table>


</section>





</body>
</html>