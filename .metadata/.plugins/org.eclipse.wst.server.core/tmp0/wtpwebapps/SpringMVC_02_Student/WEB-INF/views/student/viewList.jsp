<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>학생리스트</h2>
<c:forEach items="${stdList}" var="dto">			<!-- jstl, core, taglib를 사용한 tag 코드를 시작 c: -->
					<!--  forEach, java의 확정 for(DTO : List)와 같은 역할 -->
					
					${dto.st_num }
					${dto.st_name }
					${dto.st_dept }
					${dto.int_grade }
					${dto.st_tel }
				

</c:forEach>								
<p> ${stdList[0].st_num }
<p> ${stdList[0].st_name }
<p> ${stdList[0].st_dept }
<p> ${stdList[0].int_grade }
<p> ${stdList[0].st_tel }

<p> ${stdList[1].st_num }
<p> ${stdList[1].st_name }
<p> ${stdList[1].st_dept }
<p> ${stdList[1].int_grade }
<p> ${stdList[1].st_tel }

<p> ${stdList[2].st_num }
<p> ${stdList[2].st_name }
<p> ${stdList[2].st_dept }
<p> ${stdList[2].int_grade }
<p> ${stdList[2].st_tel }
</body>
</html>