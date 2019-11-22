<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

/*

	-EL(extend Language) tag
	JSP에서 디자이너와 개발자의 협업 중에 많은 문제들이 발생함
	
	java 진영에서는 이러한 문제를 줄이기 위해 
	HTML 코드 내에서 최소한의 Java 문법만을 사용하여 디자이너와 협업을 할 수 있도록 EL Tage라는 특별한 언어 구조를 만들어 냄
	
	현재 MVC패턴에서도 대부분의 코드는 EL tag로 구현이 되고 있음
	
	
	${변수, 연산식 등등...}
	
	*/
%>
<h3>${param.strName}의 페이지</h3>
<h3>${30+40}</h3>
<h3>${100 * 100 }</h3>
<h3>${'대한민국' }</h3>
<h3>${param.num1 + param.num2}</h3>
</body>
</html>