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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${rootPath}/js/jquery-3.4.1.js"></script>




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
		
			document.location.href="${rootPath}/memo/update?id=" + ${memoDTO.m_seq}			// 새 페이지를 만들어 지금 페이지 위에 겹쳐서 보임(뒤로가기 -> 돌아가기)
			
			
		})
		
		
		
		$("#btn-delete").click(function(){
		
			
			if(confirm("메모를 삭제합니다!!")){

				let query = "${rootPath}/memo/delete?m_seq=${memoDTO.m_seq}"		
				document.location.replace(query)							// 현재 페이지를 지우고 새 페이지로 그림(뒤로가기 -> history에 저장된 엉뚱한 페이지로 이동)
				
			}
			
			
			
			
		})
		
		
		
		
		
	})
	
</script>


<body>

<%

/*
private long m_seq;//	number
private String m_date;//	varchar2(10 byte)
private String m_time;//	varchar2(8 byte)
private String m_auth;//	nvarchar2(20 char)
private String m_subject;//	nvarchar2(125 char)
private String m_text;//	nvarchar2(1000 char)
private String m_flag;//	varchar2(1 byte)
private String m_field;//	nvarchar2(20 char)
private String m_ok;//	varchar2(1 byte)
private String m_cat;//	nvarchar2(50 char)
*/

%>




	<table>
	
		<caption>심플 메모장</caption>
	
		<tr>
		<th>SEQ</th><td>${memoDTO.m_seq}</td>
		<th>작성자</th><td>${memoDTO.m_auth}</td>
		</tr>
		
		<tr>
		<th>작성일자</th><td>${memoDTO.m_date}</td>
		<th>작성시각</th><td>${memoDTO.m_time}</td>
		</tr>
		
		<tr>
		<th>제목</th><td colspan="3">${memoDTO.m_subject}</td>
		</tr>
		
		<tr>
		<th>세부내용</th><td colspan="3">${memoDTO.m_text}</td>
		</tr>
		
	
	
	</table>
	
	<br/><br/>
	
	<div class="btn-box">
	
	<a href="javascript:void(0)" class="btn" id="btn-update">수정</a>				<!--  아무런 반응X (javascript:void(0) -->
	<a href="javascript:void(0)" class="btn" id="btn-delete">삭제</a>
	
	</div>
</body>
</html>