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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function(){
	
		/*
		$("#btn-save").click(function(){
		
			
			let pass = $("#u_password").val()
			if(pass == ""){
				
				alert("비밀번호를 입력하세요")
				$("#u_password").focus()
				return false;											// ??????????????????????
				
			}
			
			let re_pass = $("#re_password").val()
			if(re_pass == ""){
				alert("비밀번호를 한번 더 입력해 주세요")
				$("#re_password").focus()
				return false;
			}
			
			
			if(re_pass != pass){
				alert("비밀번호 입력 다시 확인")
				$("#u_password").val("")
				$("#re_password").val("")
				$("#u_password").focus
				return false;
			}
			
			
			*/
			
			let u_name = $("#u_name").val()
			if(u_name == ""){
				alert("일므은 반드시 입력해야 함")
				$("#u_name").focus()
				return false;
			}
			
			
			$("form").submit()
			
			
			
			
		})
		
		
		
		
	})
	
	

</script>




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
	
	
	.in-error{
		
		display:inline-block;
		margin-left: 20px;
		font-size:12px;
		color:red
		}
		
	input:hover{
		background-color: #ddd;
		border: 2px solid red;
	}
</style>
</head>
<body>




<fieldset>
<legend>
	<c:if test="${TITLE == null}">회원가입</c:if>
	<c:if test="${TITLE != null}">${TITLE}</c:if>
</legend>
<form:form modelAttribute="userDTO" autocomplete="on" class="user-form">		<!-- html의 form은 default method가 GET인데 form:form tag는 default method가 POST -->


<div class="in-box-border">
	<form:input type="text" path="u_id" class="in-box" placeholder="이메일주소를 입력하시오"/>	<br>											<!-- html의 inputbox와 달리 name이라는 속성을 사용하지 않고 path라는 속성이 변수설정 역할을 수행 -->
	<form:errors path="u_id" class="in-error"/>
</div>

	<div class="in-box-border">	
		<form:input type="password" path="u_password" class="in-box" placeholder="비밀번호를 입력하세요"/>	<br>
		<form:errors path="u_password" class="in-error"/>
</div>
	
<div class="in-box-border">	
	<form:input type="password" path="re_password" placeholder="비밀번호를 다시 입력"/>	<br>						<!-- 비밀번호 확인은 서버로 데이터를 전송할 필요가 없기																						때문에 input box를 표준 html로 작성
																														또한 form:input으로 작성하게 되면 
																														DTO에 해당 필드변수를 작성해야 하는 불편이 있기 때문에 이 항목에 입력된 값은
	
																																			서버로 전송ㅎ기 전 두번 입력한 비밀번호가 같은지만 검사하면 되기 때문 -->
	
	<form:errors padth="re_password" class="in-error"></form:errors>
	</div>
	

	<div class="in-box-border">	
	<form:input path="u_name" class="in-box" placeholder="이름 입력"/>
	<form:errors path="u_name" class="in-error"/>
	</div>
	
	<div class="in-box-border">	
	<form:input path="u_nick" class="in-box" placeholder="별명 입력"/>
	<form:errors path="u_nick" class="in-error"/>
	</div>
	
	<div class="in-box-border">
	<form:input path="u_tel"  type="number" class="in-box" placeholder="전화번호를 숫자만으로 입력"/>
	<form:errors path="u_tel" class="in-error"/>
	</div>
	
	
	
		<div class="cat-box">
		
 
 
	</div>
	
	<button type="button" id="btn-save">저장</button>
	
	
</form:form>
</fieldset>
</body>
</html>