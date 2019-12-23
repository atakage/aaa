





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<script>
$(function(){
	
	
	
	
	
	$("#btn_all").click(function(){
	
		
		
		$.ajax({
			
			url : '${rootPath}/plist', success: function(proList){
				
				
				
				$('article.detail').html(proList)
				
				
				
				
				
				/*
				proList.forEach(function(vo){						// vo 무엇?
				
							$("article.detail").append(
									$("<p/>", {text: vo.p_name}, "<p/>", {text: vo.p_code}, "<p/>", {text: vo.p_oprice}, "<p/>", {text: vo.p_iprice})		// "<p><span>" + vo.p_name + "</span>"
									
							)
						
				})
				
				*/
			}
			
		})
		
	})
	
	
	
	
	
	$("#btn_search").click(function(){
		
		var in_p_code = $("#p_code").val()
		$.ajax({
			
			
			url : '${rootPath}/pname', data : {p_code : in_p_code}, success : function(result){ 		// p_code 컨트롤러의 매개변수와 이름 같게?
				
				$("article.detail").append($("<p/>",{html: result, class: 'pc'} ) )								// '<p>' + result + '</p>'
				
			}, error: function(error){
				$("article.detail").text(result)
			}
			
			
			
		})
		
		
	})
	
	
	
	
	
	
	

	
	$("#p1").click(function(){
		
		
		$("#p2").text("대한민국만세")
		let i1 = $("#input-1").val()
		$("#p3").text(i1)
		
		
	})
	
	
	$("#ajax").click(function(){
	
		
		$.ajax({url:"${rootPath}/nation", data: {str:$("#input-1").val()},
			success: function(result){						// success 이하??
		
			$("#p4").text(result)
		}
		})
		
		
	})
	
	
	
	
})


</script>



<style>

*{
	
	margin: 0 auto;
	padding: 0;
	box-sizing: border-box;
}

header{
	background: green;
	color: white;
	padding: 0.8rem;
}

nav{
	background: rgba(0, 255, 0, 0.3)
}


table.p-main{

	width:95%;
	margin: 10 auto;
	border-collapse: collapse;
	border: 1px solid green;
}


article{
	border: 1px blue solid;
	margin: 10px auto;
}


ul{

	display: flex;
	list-style: none;
}

ul a{

	text-decoration: none;
	display: inline-block;
	padding: 14px 10px;
	
}

table.p-list{
	
	width:95%;
	margin: 10px auto;
	border-collapse: collapse;
	border: 1px solid green;
	

}
	
	

article.detail{


	height: 500px;
	overflow: auto;


}

</style>


<title>Insert title here</title>
</head>
<body>
<header>
	<h3>Product</h3>
</header>
<nav>
	<ul>
	<li><a href="#">Logo</a></li>
	<li><input id="p_code"><button id="btn_search">검색</button></li>
	<li><button id="btn_all">상품리스트 가져오기</button>
</ul>
</nav>
<section>

	<article class="main">
		<table class="p-main" border="1">
		
			<tr>
				<th>상품코드</th>
				<th>상품이름</th>
			</tr>
			
			
			
	
			
			
			<tr class="p_list">
				<td></td>
				<td></td>
			</tr>
		</table>	
	</article>
	
	<article class="detail">
	
	</article>
</section>

</body>
</html>