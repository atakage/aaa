<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<article>


<ul class="pagination">
	<c:if test="${pageDTO.startPageNo > 1}">
	<li class="page-item"><a href="${rootPath}/plist?currentPageNo=1"  class="page-link">1</a>
	<li class="page-item"><a href="${rootPath}/plist?currentPageNo=${pageDTO.prePageNo}"  class="page-link">&lt;</a>
	</c:if>
	
	<c:if test="${pageDTO.startPageNo > 2}">
	<li class="page-item"><a  class="page-link">&middot;&middot;&middot;</a>
	</c:if>
	
	<c:forEach begin="${pageDTO.startPageNo }" end="${pageDTO.endPageNo}" var="pageNo">
	<li class="page-item" <c:if test="${pageNo == pageDTO.currentPageNo}"> active</c:if>>
	<a class="page-link" href="${rootPath}/plist?currentPageNo=${pageNo}"></a>
	</c:forEach>
	
	<c:if test="${pageDTO.endPageNo != pageDTO.finalPageNo}">
		<li class="page-item"><a href="${rootPath}/plist?currentPageNo=${pageDTO.nextPageNo}"  class="page-link"> &gt;</a>
		<li class="page-item"><a  class="page-link">&middot;&middot;&middot;</a>
		<li class="page-item"> <a href="${rootPath}/plist?currentPageNo=${pageDTO.finalPageNo}"  class="page-link">${pageDTO.finalPageNo}</a>
	</c:if>
	
</ul>


</article>