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
	
	[type=radio]{
	
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
<legend>메모작성</legend>
<form:form modelAttribute="memoDTO" class="memo-form">		<!-- html의 form은 default method가 GET인데 form:form tag는 default method가 POST -->




	



	

	<div class="cat-box">
		<form:radiobuttons path="m_cat" items="${CATS}" itemLabel="catName" itemValue="catValue"/>
 
 <!-- 
		<form:radiobutton path="m_cat" value="today" label="오늘할일"/>
		<form:radiobutton path="m_cat" value="promise" label="약속"/>
		<form:radiobutton path="m_cat" value="tops" label="중요메모"/>
		-->
	</div>
	
	 
	<form:label path="m_date">작성일</form:label>
	<form:input type="date" path="m_date" class="in-box" placeholder="작성일자"/>	<br>											<!-- html의 inputbox와 달리 name이라는 속성을 사용하지 않고 path라는 속성이 변수설정 역할을 수행 -->


	<form:label path="m_time">작성시각</form:label>
	<form:input type="time" path="m_time" class="in-box" placeholder="작성시각"/>	<br>
	
	<form:label path="m_auth">작성자</form:label>
	<form:input path="m_auth" class="in-box" placeholder="작성자id"/>
	
	
	<form:input path="m_subject" class="in-box" placeholder="제목을 입력하세여"/>
	<form:textarea path="m_text" rows=""/> <br>
	
	<button>저장</button>
	
	
</form:form>
</fieldset>
</body>
</html>