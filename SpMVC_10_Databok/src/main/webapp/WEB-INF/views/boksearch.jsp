<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">




<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<script type="text/javascript">

$(function(){

	$("#btn-search").click(function(){
	
		
		
		
		var queryString = $("form").serialize();	// form에 입력된 데이터를 json type으로 바꾸어 서버에 전송할 수 있도록 (문자열화)
		
		
		
		/*
		
		Async JavaScript XML
		비동기 방식으로 서버에 request를 보낼 때 사용하는 JS의 내장 프로토콜
		1.web에서 ajax에서 req를 요청하면
		2. ajax는 즉시 ok를 보내서 web이 다른 작업을 수행할 수 있도록 하고
		3. ajax는 매개변수로 설정된 항목에 의해서 서버에 request를 보냄
		4. 서버에서 정상적으로 response를 보내면  success에 설정된 함수를 실행
		
		5. success에 설정된 함수에 여러가지 코드를 작성하여 결과처리
		
		
		*/
		
		$.ajax({
			
			url:"${rootPath}/searchAPI",
			data:queryString, type:'post',
			//dataType:'json',		// response로 받을 데이터 타입
			success:function(result){	// 결과 성공했을 때
				//resFunc(result)
				$("#bok-list").html(result)
			}
			,error:function(xhr, status, error){		// 서버에서 오류 보낼 때
				alert(error)
			}
			
		})
		
		
	})
})
				
			
			
			
		



</script>



</head>
<body>


<style>
	fieldset div{
		display:flex;
		

	
	}
	
	
	fieldset{
		width:80%;
		border: 1px solid green;
		border-radius: 10px;
		margin: 10px auto;
		 
	}
	
	fieldset div label{
	
	
		display:inline-block;
		width:15%;
		padding: 8px 10px;
		margin: 2px;
		margin-right: 5px;
		text-align:right;
		vertical-align: center;
	}
	
	fieldset div input, fieldset div select{
	
	
		display:inline-block;
		width:70%;
		padding: 8px;
		margin: 5px;
		border: 1px solid #ddd;
	
	}

</style>



<form:form modelAttribute="bokSearchDTO">
	<fieldset>


<div>
<label for="">검색분류</label>
<form:select path="srchKeyCode" label="검색분류">
	<form:options items="${SeMaps.srchKeyCode}"/>
</form:select>
</div>

<div>
<label for="searchWrd">검색어</label>
<form:input path="searchWrd" label="검색어"/>
</div>

<div>
<label for="lifeArray">생애주기</label>
<form:select path="lifeArray" label="생애주기">
	<form:options items="${SeMaps.lifeArray}"/>
</form:select>
</div>

<div>
<label for="charTrgterArray">대상특성</label>
<form:select path="charTrgterArray" label="대상특성">
	<form:options items="${SeMaps.charTrgterArray}"/>
</form:select>
</div>

<div>
<label for="obstKiArray">장애유형</label>
<form:select path="obstKiArray" label="장애유형">
	<form:options items="${SeMaps.obstKiArray}"/>
</form:select>
</div>

<div>
<label for="obstAbtArray">장애정도</label>
<form:select path="obstAbtArray" label="장애정도">
	<form:options items="${SeMaps.obstAbtArray}"/>
</form:select>
</div>

<div>
<label for="trgterIndvdlArray">가구유형</label>
<form:select path="trgterIndvdlArray" label="가구유형">
	<form:options items="${SeMaps.trgterIndvdlArray}"/>
</form:select>
</div>

<div>
<label for="desireArray">욕구</label>
<form:select path="desireArray" label="욕구">
	<form:options items="${SeMaps.desireArray}"/>
</form:select>
</div>


<div>
	<label></label>
	<button id="btn-search" type="button">조회</button>
</div>

</fieldset>
</form:form>





</body>
</html>