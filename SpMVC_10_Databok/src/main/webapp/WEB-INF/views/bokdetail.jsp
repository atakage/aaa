<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">




<title>Insert title here</title>
</head>
<body>








<p>
<p>${detail.inqplCtadrList.servSeDetailNm}
<p>${detail.inqplCtadrList.servSeDetailLink}

<p>${detail.inqplHmpgReldList.servSeDetailNm}
<p>${detail.inqplHmpgReldList.servSeDetailLink}

<p>
<p>


<p>
<p>




<p>서비스 이용 및 신청방법:
<p><img src="${detail.applmetList.servSeDetailLink}" alt="신청방법">

<p>문의처:${detail.inqplCtadrList.servSeDetailNm}
(${detail.inqplCtadrList.servSeDetailLink})

<p>사이트명:<a href="${detail.inqplHmpgReldList.servSeDetailLink}">
${detail.inqplHmpgReldList.servSeDetailNum}
</a>


<p>서식/자료명:${detail.basfrmList.servSeDetailNm}
<p>서식자료링크:${detail.basfrmList.servSeDetailLink}

<p>근거법령명:${detail.baslawList.servSeDetailNm}
<p>근거법령링크:${detail.baslawList.servSeDetailLink}




	<section>
	
		<div></div>
	
	</section>

</body>
</html>