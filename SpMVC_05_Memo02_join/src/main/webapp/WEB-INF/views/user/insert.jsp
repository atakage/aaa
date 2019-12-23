<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath}"/>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>			<!-- spring-form tag lib 
    																								html의 input, form 등의 입력 box용 tag를 확장하여 spring controller와
    																													연동을 쉽게 도와줌 -->
    														
    																													
    
    																													
	    																													
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">




<title>Insert title here</title>
<style>
	fieldSet{
		width:70%;
		margin: 20px auto;
		border: 1px solid green;
		border-radius: 10px;
	}
	
	legend{
		font-weight: bold;
		font-size:20px;
	}
	
	input{
		display:inline-block;
		width: 90%;
		padding:8px;
		margin:5px;
		border-radius:20px;
		text-alrea
	}
	
	input:focus, textarea:focus, button{
		border: 2px solid blue;
		outline:none;
	}
	
	div.cat-box{
	
		width:90%;
		padding:6px;
		padding-top:4px;
		padding-bottom: 10px;
	
	}
	
	[type=radio], [type=checkbox]{
	
		width: 24px;
		height: 24px;
		position: relative;
		margin-left: 15px;
		top: 6px;
		text-align: top;
	
	}
</style>
</head>
<body>




<fieldset>
<legend>회원가입</legend>
<form:form modelAttribute="userDTO" autocomplete="on" class="user-form">		<!-- html의 form은 default method가 GET인데 form:form tag는 default method가 POST -->




	 
	
	<form:input type="email" path="u_id" class="in-box" placeholder="이메일주소를 입력하시오"/>	<br>											<!-- html의 inputbox와 달리 name이라는 속성을 사용하지 않고 path라는 속성이 변수설정 역할을 수행 -->


	
	<form:input type="password" path="u_password" class="in-box" placeholder="비밀번호를 입력하세요"/>	<br>
	<input type="password" id="re_password" placeholder="비밀번호를 다시 입력"/>	<br>
	
	
	<form:input path="u_name" class="in-box" placeholder="이름 입력"/>
	
	<form:input path="u_nick" class="in-box" placeholder="별명 입력"/>
	
	<form:input path="u_tel"  type="number" class="in-box" placeholder="전화번호 입력"/>
	
	
	
		<div class="cat-box">
		<form:checkboxes path="u_hobby"  itemLabel="h_name" itemValue="h_code" items="${HO_LIST}" />
 
 
	</div>
	
	<button>저장</button>
	
	
</form:form>
</fieldset>
</body>
</html>