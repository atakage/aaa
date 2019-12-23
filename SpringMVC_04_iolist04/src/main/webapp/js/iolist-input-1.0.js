$(function(){
	
	
	var calc = function(){
	
		
		let price = parseInt($("#io_price").val())
		let qty = parseInt($("#io_qty").val())
		
		let total = price * qty
		
		$("#io_total").val(total)
		
	}
	
	
	
	$("#btn-save").click(function(){
		
		let dCode = $("#io_dcode").val()
		if(dCode == ""){
			alert("거래처코드는 반드시 입력해야 합니다")
			$("#io_dcode").focus()
			return false								// 이후 if문 진행X
		}
		
		let pCode = $("#io_pcode").val()
		if(pCode == ""){
			alert("상품코드는 반드시 입력해야 함")
			$("#io_pcode").focus()
			return false
		}
		
		
		
		
		
		if(confirm("저장할까요")){
			$("form").submit()					// 
		}
		
	})
	
	
	
	$("#io_price").on("change keyup paste input propertychange", calc)
	$("#io_qty").on("change keyup paste input propertychange", calc)
	
	
	
	
	$("#io_dcode").keypress(function(e){		// 입력박스에서 enter키 입력 감지 위함
	
		
		if(e.keyCode == 13){		// enter키 입력되면
			
			//현재 거래처 코드 input box에 입력된 값을 추출
			
			let strText = $(this).val()
			let query = rootPath
			query += "/dept/search?strText=" + strText				// 컨트롤러??
			
			let status = "toolbar=no, scrollbars=yes, resizable=no, top=200, left=200, width=400, height=400"
			window.open(query, "_blank", status)	// 새 브라우저 창을 열어 조회하는 조회 내용을 보임
			
			
			
			
		}
		
		
		
	})
	
	
	
	
	
	
	


		
	// 입력box에 키보드로 뭔가를 입력할 때마다 발생하는 이벤트
		
							// 키보드 이벤트(keydown, keypress, keyup)
							// keydown: 키보드를 누르는 순간 발생
							// keypress: 글자가 입력되어서 컴퓨터로 ??? 순간, 어떤 글자가 입력되었는가를 캐치하기 위한 이벤트
							// keyup: 키보드에서 손을 떼는 순간 발생
							
		
	$("#io_pcode").keypress(function(event){	// 키보드에서 어떤 문자를 입력하면 event의 keyCode라는 속성에 문자의 ASCII 코드값이 저장되어 전달됨
		
		if(event.keyCode == 13){	// 13 == Enter키, 28 == esc
			let strText = $(this).val()
			let query = rootPath
			query += "/product/search?strText="+strText
			
			
			let status = "toolbar=no,"
				status += "scrollbars=yes,"
					status += "resizable=no,"
						status += "top=300,"
							status += "left=500,"
								status += "width=700,"
									status += "height=500"
			window.open(query , "_blank", status)
		}
		
		
	})
	
	
})
