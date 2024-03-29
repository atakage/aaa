<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>취업지원정보 - 개선의견수렴</title>
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
	
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
<%@ include file="/WEB-INF/views/include/include-table.jspf" %>
    <section class="news_section">
        <article>
            <p>개선의견수렴</p>
        </article>
        <article class="opinion_table">
            <table>
                <tr>
                    <th>제목</th>
                    <td><input name="opinion_submit" placeholder="내용을 입력해주세요"></input></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><input name="opinion_submit" placeholder="내용을 입력해주세요"></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input name="opinion_submit" placeholder="내용을 입력해주세요"></td>
                </tr>
            </table>
            <div>
                <button>등록</button>
            </div>
        </article>
    </section>
    <%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>