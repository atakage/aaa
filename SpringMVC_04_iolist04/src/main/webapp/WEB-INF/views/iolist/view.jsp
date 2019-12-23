<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${rootPath}/css/top-scroll.css?ver=20191128001" rel="stylesheet" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>




<title>Insert title here</title>
</head>

<style>


	table{
		
		width:70%;
		margin:20px auto;
		border-top: 2px solid #252525;
		border-bottom: 1px solid #ccc;
	}
	
	
	table th{
	
	text-align: : left;
	background-color: #f7f7f7;
	color: #3b3b3b;
	
	}
	
	table th, table td{
	
		padding: 15px 0 16px 16px
		border-bottom: 1px solid #ccc;
		
	}
	
	caption{
	
	 font-size: 25px;
	 padding: 10px;
	 font-weight: bold;
	 color: blue;
	 
	}
	
	a.btn{
		border-radius: 3px;
		padding: 5px 11px;
		color: #fff;
		display: inline-block;
		background-color: #6b9ab8;
		border: 1px solid #56819d;
		vertical-align: middle;
		text-decoration: none;
	}
	
	div.btn-box{
		width:70%;
		display: flex;
		justify-content:center;
		align-items: center;
		margin: 5px auto;
	}
	
	
	a.btn:hover{
		border: 1px solid blue;
		box-shadow: 5px 5px 8px  rgba(80,80,80,0.8)
		
		}

</style>


<script>
	$(function(){
	
		
		$("#btn-update").on("click", function(){
		
			document.location.href="${rootPath}/iolist/update?id=" + ${IO_DTO.io_seq}			// 새 페이지를 만들어 지금 페이지 위에 겹쳐서 보임(뒤로가기 -> 돌아가기)
			
			
		})
		
		
		
		$("#btn-delete").click(function(){
		
			let query = "${rootPath}/iolist/delete?id=${IO_DTO.io_seq}"		
			document.location.replace(query)							// 현재 페이지를 지우고 새 페이지로 그림(뒤로가기 -> history에 저장된 엉뚱한 페이지로 이동)
			
		})
		
		
		
		
		
	})
	
</script>


<body>


	<table>
	
		<caption>매입매출 상세</caption>
	
		<tr>
		<th>SEQ</th><td>${IO_DTO.io_seq}</td>
		<th>거래구분</th><td>${IO_DTO.io_inout}</td>
		</tr>
		
		<tr>
		<th>거래일자</th><td colspan="3">${IO_DTO.io_date}</td>
		</tr>
		
		<tr>
		<th>거래처</th><td>${IO_DTO.io_dcode}</td>
		<th>거래처명</th><td>${IO_DTO.io_dname}( ${IO_DTO.io_dceo} )</td>
		</tr>
		
		<tr>
		<th>상품코드</th><td>${IO_DTO.io_pcode}</td>
		<th>상품명</th><td>${IO_DTO.io_pname}</td>
		</tr>
		
		
		<tr>
		<th>수량</th><td>${IO_DTO.io_qty}</td>
		<th>단가</th><td>${IO_DTO.io_price}</td>
		</tr>
		
		<tr>
		<th>합계</th><td colspan="3">${IO_DTO.io_total}</td>
		</tr>
	
	
	</table>
	
	<br/><br/>
	
	<div class="btn-box">
	
	<a href="javascript:void(0)" class="btn" id="btn-update">수정</a>				<!--  아무런 반응X (javascript:void(0) -->
	<a href="javascript:void(0)" class="btn" id="btn-delete">삭제</a>
	
	</div>
</body>
</html>