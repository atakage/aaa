<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">




<title>Insert title here</title>
</head>
<body>
<p><a href="#{rootPath}/param/update?id=10">나는 코드가 10번입니다</a>

<!-- update나 delete request를 호출할 때 query 변수명은 dto에서 사용하지 않는 이름으로 명명 -->


</body>
</html>