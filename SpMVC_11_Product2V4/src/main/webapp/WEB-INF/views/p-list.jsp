<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="rootPath" value=" ${pageContext.request.contextPath}" />



<script>



$(function(){
	
	
	// 동적 tag: 스크립트를 이용해 임의로 append한 태그
	
	
	$(document).on("click", "p.img-delete", function(){		// jquery에서 동적으로 생성한 tag에 이벤트 주기
		
		let file_name = $(this).attr("data-name")
		
		if(confirm(file_name + "이미지를 삭제합니다")){
			let file_seq = $(this).attr("data-id")
//			document.location.href="${rootPath}/subImgDelete?file_seq" + file_seq
		
		
		$.ajax({
			
			url:"${rootPath}/rest/subImgDelete", data: {file_seq : file_seq}, success : function(p_code){
				getProInfo(p_code)
			}
			
		})
		
		}
		
	})
	
	$(document).on("click", "p.img-view", function(){	
		
		let file_name = $(this).attr("data-upload")
		window.open("${rootPath}/files/" + file_name,"_new", "toolbar=no, scrollbars=no")
		
	})
	
	
	$("tr.p-row").click(function(){							// 코딩으로 만든 tag에 이벤트 주기
		
		
		let p_code = $(this).attr("data-id")
		getProInfo(p_code)
	})
	
	
	
	var getProInfo = function(p_code){
		
	
		
		$.ajax({
			
			// "getProduct?p_code=" + p_code			
			url:"${rootPath}/rest/getProduct", data:{p_code : p_code}, dataType: 'json', success:function(result){
				
				
				$("#p_code").val(result.p_code)
				$("#p_name").val(result.p_name)
				$("#p_iprice").val(result.p_iprice)
				$("#p_oprice").val(result.p_oprice)
				$("#p_file").val(result.p_file)
				let profileImage = "${rootPath}/files/noimage.png"
				
				if(result.p_file != null){
					
					profileImage = "${rootPath}/files/" + result.p_file
					
				}
				
				$("#p_image").attr("src", profileImage)
				
				
				
				if(result.p_vat == "1"){
					
					$("#p_vat").attr("checked", "checked")
				}else{
					$("#p_vat").attr("checked", "")
				}
				
				$("#p_sub_list").html("")
				if(result.p_files.length > 0){
					
					
					
					
					$("#p_sub_list").html("")
					
				
					
					
				result.p_files.forEach(function(file){
					
					var imgTag = $("<img/>",{
						width:"100px",
						height:"100px",
						margin: "10px",
						"class": "sub-img", "data-id" : file.file_seq, "data-name": file.file_origin_name,
						src : "${rootPath}/files/" + file.file_upload_name
					})
					
					
					var delTag = $("<p/>", {"class":"img-delete", "data-id": file.file_seq, "data-name": file.file_origin_name, "text" : "삭제",
						
						
					})
					
					
					
					var viewTag= $("<p/>", {"class":"img-view", "data-id": file.file_seq, "data-name": file.file_origin_name, "data-upload": file.file_upload_name,
						"text" : "미리보기",
					
					})
					
					
					$("#p_sub_list").append(
							$("<div/>", {"class": "container"}).append(
									imgTag,
									
									$("<div/>", {"class":"over"}).append(
											
											delTag, viewTag
									)
							)
							)
						
				})	
				
				
				
				}
								
				
			}, error: function(){
				alert("서버 통신 오류")
			}
			

		
		
})
		
		
		
		
		
	}
	
	
})
</script>


<style>
td, th {
	white-space: nowrap;
}


	 
    	div.container{
    	
    		position:relative;
    		
    		diplay:flex;
    		justify-content: center;
    		align-items: center;
    			
    	
    	}
    	div.container .over{
    		position:absolute;
    		top:0;
    		bottom:0;
    		left:0;
    		right:0;
    		width: 100%;
    		opacity:0;
    		transition: 0.5s ease;
    		background: #008CBA;
    	}
    	
    	div.container:hover .over{
    	
    		opacity:1;
    	}
    	
    	p.img-delete, p.img-view{
    		display: inline-block;
    		width:150px;
    		color:white;
    		font-size: 20px;
  			cursor: pointer
    	}
    	
    	
    	p.img-delete:hover, p.img-ivew:hover{
    	text-decoration: underline;
    	color:yellow;
    	}
</style>
<body>
	<table class="p-list table table-striped table-hover">
		<thead class="thead-dark">
			<tr>
				<th>상품코드</th>
				<th>상품명</th>
				<th>매입단가</th>
				<th>매출단가</th>
				<th>대표이미지</th>
				<th>보조이미지</th>
			</tr>
		</thead>

		<c:forEach items="${PLIST}" var="vo">

			<tr class="p-row" data-id="${vo.p_code}">
				<td>${vo.p_code}</td>
				<td>${vo.p_name}</td>
				<td>${vo.p_iprice}</td>
				<td>${vo.p_oprice}</td>
				<td><c:if test="${!empty vo.p_file}">0</c:if></td>
				<td><c:if test="${!empty vo_files}">0(${fn:length(vo.p_files)})</c:if></td>
			</tr>

		</c:forEach>


	</table>
</body>
</html>