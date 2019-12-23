<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath }" />
    
    
    
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<link href="${rootPath}/css/list-table.css" rel="stylesheet" type="text/css">
<link href="${rootPath}/css/top-scroll.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>
</head>
<body>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>

p #insert{
	
	margin-left: 40px;
}

</style>
<script>
	$(function(){
		
		
		 var preScroll = $(window).scrollTop();      // 현재 보고 있는 화면의 scroll top값을 추출하여 변수에 임시 보관
		
		
		
		
		$(".content-body").click(function(e){
			
			let d_code = $(this).attr("id")				// id에 설정된 값을 가져오기
			alert(d_code)
			document.location.href="${rootPath}/dept/view?d_code=" + d_code			// 주소창에 /dept/view + id값을 실어 보내라
					
			
		})
		
		
		
		
		 
            $(window).scroll(function(e){

                let curScroll  = $(window).scrollTop();
                if(preScroll > curScroll){      // 아래방향으로 스크롤을 시도

                    $("ul.main-menu").css("top", 0)
                }else{
                    $("ul.main-menu").css("top", -80)
                }

                preScroll = curScroll

            })
		
		
		
	})
	
	
	
	
</script>






<section class="dept">
	<article>
		<p id="insert"><a href="${rootPath}/dept/insert"><button>새로등록</button></a>
	</article>

	<article>
	
		<table>
		
			<tr>
				<th>NO</th>
				<th>거래처코드</th>
				<th>거래처명</th>
				<th>대표</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<c:choose>
				<c:when test="${empty DEPTLIST}">
					<tr><td colspan="5">데이터가 없음</td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${DEPTLIST}" var="dto" varStatus="info">
					
					<tr class="content-body" id="${dto.d_code}">
						<td>${info.count}</td>
						<td>${dto.d_code}</td>
						<td>${dto.d_name}</td>
						<td>${dto.d_ceo}</td>
						<td>${dto.d_tel}</td>
						<td>${dto.d_addr}</td>
					</tr>
					</c:forEach>
				</c:otherwise>
		</c:choose>
		</table>
	
	</article>

</section>

</body>
</html>