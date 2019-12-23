<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>취업지원정보 - 소식 세부사항</title>
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
<link rel="stylesheet" href="${rootPath}/css/table.css?ver=20191121001" type="text/css">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
	
	<section>
        <article>
            <p> 소식 </p>
        </article>
        <article class="news_detail">
            <table border="1">
                <tr>
                    <th>제목</th>
                    <td colspan="3">제목이 나올 곳</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>작성자 나올 곳</td>
                    <th>등록일</th>
                    <td>등록일 나올 곳</td>
                </tr>
            </table>
            <div>
                <p>고용노동부 공고 제2019-422호</p>
                <p>고용노동부에서는 근로시간 단축 제도 시행에 따른 통계 분석 업무 담당과 공무원 인재개발 및 교육 훈련 업무 담당 및 최저임금위원회의 통계 분야 지표 조사·분석 업무를 담당할 전문가를 다음과 같이 공개 모집하오니, 참신하고 유능한 분들의 많은 응모를 바랍니다.</p>
                <p></p>
            </div>
            <table border="1">
                <tr class="news_detail_file">
                    <th>첨부파일</th>
                    <td>파일 링크</td>
                </tr>
            </table>
            <article class="news_page_button">
                <button>목록</button>
            </article>
        </article>
    </section>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
	
</body>
</html>
