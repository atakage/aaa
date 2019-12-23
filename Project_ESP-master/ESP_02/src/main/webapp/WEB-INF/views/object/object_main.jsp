<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${rootPath}/css/home.css?ver=20191121001" type="text/css">
    <link rel="stylesheet" href="${rootPath}/css/header.css?ver=20191121001" type="text/css">
    <link rel="stylesheet" href="${rootPath}/css/mainnav.css?ver=20191121001" type="text/css">
    <link rel="stylesheet" href="${rootPath}/css/sidenav.css?ver=20191121001" type="text/css">
    <link rel="stylesheet" href="${rootPath}/css/body.css?ver=20191121001" type="text/css">
    <link rel="stylesheet" href="${rootPath}/css/table.css?ver=20191121001" type="text/css">
    <link rel="stylesheet" href="${rootPath}/css/footer.css?ver=20191121001" type="text/css">
<title>취업지원정보 - 대상별 정책</title>
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
	
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
    <div class="side_section">
        <%@ include file="/WEB-INF/views/include/include-side.jspf" %>
        <section>
        <!-- <p style="font-size:300px;">본문</p> -->
        <p class="section_title"><strong>대상별 정책</strong></p><br><br><br>
        <p></p>
        <p></p>
        <p>각 대상들을 위해서 만들어진 정책들을 볼 수 있는 페이지</p>
        <p></p>
        <p></p>
            <!-- <article>
                <p style="font-size:300px;">본문</p>
            </article> -->
        </section>
    </div>
<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>
