<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>



<script type="text/javascript">

$(function(){
	



	$("#id_use").click(function(){			// 아이디 사용 버튼 클릭하면
		
	
		$("#u_id", opener.document).val($("#u_id").val())		// 회원가입 창의 u_id input box에 현재창의 u_id값을 보내기
		
		
		window.close()// 현재 창 닫기
		
		
		window.open('about:blank','_self').self.close()	// IE창 닫기
		
		
	})
	
	
	
})	

</script>




<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${ID_YES}">
		<h3>이미 가입된 아이디</h3>
	</c:when>
	
	<c:when test="${ID_YES == false  && empty u_id}">
		<h3>아이디를 입력하시오</h3>
	</c:when>
	
	<c:otherwise>
		<h3>사용할 수 있는 아이디</h3>
	</c:otherwise>
</c:choose>

<form>
	<input name="u_id" id="u_id" value="${u_id}">
	<button>다시검색</button>
	<button type="button" id="id_use">아이디 사용</button>
</form>



</body>
</html>