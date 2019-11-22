<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 주석코드

   주석코드를 사용할 때 꺽쇠태그 사용 금지, 본문코드와 겹쳐서 Web에 보일 때 의도하지 않은 모양으로 나타남
   느낌표 기호도 가급적 사용X -->

<%
// java script let(javaScript 아님)
	String strName = request.getParameter("strName");
	String strNum1 = request.getParameter("num1");
	String strNum2 = request.getParameter("num2");

	int intNum1 = 0;
	int intNum2 = 0;

	try {

		intNum1 = Integer.valueOf(strNum1);
		intNum2 = Integer.valueOf(strNum2);
	} catch (Exception e) {

	}

	int intSum = intNum1 + intNum2;
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<p>
			<lable>num1</lable>
			<input name="num1">
		<p>
			<lable>num1</lable>
			<input name="num2">
			
			<p><button>계산</button>
	</form>
	<h3>
		<p><%=intSum%></p>
		<p><%=strName%></p>

	</h3>
</body>
</html>