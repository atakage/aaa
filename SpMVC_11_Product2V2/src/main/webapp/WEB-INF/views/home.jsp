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


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>



<style>
	div{
		
		margin: 5px;
	
	}
	
	
	div.row{
	
		margin:0 auto;
		
	
	}
	
	div#p_list{
	
	
		height:900px;
		overflow: auto;
	
	}

	#p_image:hover:after{
		content: "x";
		background:lime;
		display:inline-block;
		position:absolute;
		top:0;
		left:0;
		
	}

</style>



<script type="text/javascript">

	$(function(){
	
		
		$("#p_image").click(function(){
		
			
			if(confirm("이미지를 삭제할까요")){
				let p_code = $("#p_code").val()
				document.location.href="${rootPath}/imgDelete?p_code=" + p_code 
			}
			
		})
		
		
		
		
	})
	

</script>


<title>Insert title here</title>
</head>
<body>
	<header class="container-fluid jumbotron text-center bg-success">

		<H3>상품 정보 관리</H3>
		<p>대한 쇼핑몰 상품정보 관리자 화면
	</header>

	<nav class="container-fluid navbar navbar-expand-sm bg-light bg-primary">
		<ul class="navbar nav">
			<li class="navbar-brand"><a class="nav-link" href="#">HOME</a></li>
			<li class="nav-item"><a class="nav-link" href="#">상품등록</a></li>
			<li class="nav-item"><a class="nav-link" href="#">재고관리</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">관리잔</a>
			</li>
		</ul>

	</nav>

	<section class="container-fluid">
	
		<article class="row d-flex justify-content-center">
		
			<div id="p_list" class="col-lg-5 col-md-11 bg-success"><%@ include file="/WEB-INF/views/p-list.jsp" %></div>
			
			
			<section class="col-lg-5 col-sm-11">
		
			
			<form class="was-validated" action="${rootPath}/input" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="p_code">상품코드:</label>
    <input type="text" class="form-control" placeholder="상품코드를 입력핫오" id="p_code" name="p_code">
  </div>
  
  <div class="form-group">
    <label for="p_name">상품이름:</label>
    <input type="text" class="form-control" placeholder="상품이름 입력" id="p_name" name="p_name" required>
    <div class="valid-feedback">Valid</div>
    <div class="invalid-feedback">상품ㅇㄹ느 반드시 입력</div>
  </div>
  
  
  <div class="form-group">
    <label for="p_price">매입가격:</label>
    <input type="text" class="form-control" placeholder="매입가격 입력" id="p_iprice" name="p_iprice" required>
    <div class="valid-feedback">Valid</div>
    <div class="invalid-feedback">매입가격은 반드시 입력</div>
  </div>
  
  
  
   <div class="form-group form-check">
						<label class="form-check-label">
						<input
							class="form-check-input" type="checkbox" 
							name="p_vat" value="1">
							과세
						</label>
					</div>
  
  
  <div class="form-group">
    <label for="p_oprice">매출가격:</label>
    <input type="text" class="form-control" placeholder="매출가격을 입력" id="p_oprice" name="p_oprice" required>
    <div class="valid-feedback">Valid</div>
    <div class="invalid-feedback">ㅁㅊㄱㄱ느 반드시 입력</div>
  </div>
  
  
    <div class="form-group">
    <input type="hidden" name="p_file" id="p_file">
    	<label></label>
    	<input type="file" class="form-controller" name="u_file" id="p_oprice">
    </div>
    
    <div class="form-group">
    	<img id="p_image" src="${rootPath}/files/noimage.png" width="200px" height="200px"/>
    </div>
  
  
  
  
  
  
  
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  <button type="reset" class="btn btn-warning">새로작성</button>
  <button type="submit" class="btn btn-primary">저장</button>
</form>
			
			
			
			
			</section>
			
			
			
	
			
			

		</article>
	</section>

	<footer class="container-fluid bg-primary">
		<address class="text-center">Copy Right &copy; callor@callor.com</address>
	</footer>
</body>
</html>