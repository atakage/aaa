package com.biz.product.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.biz.product.domain.ProductDTO;
import com.biz.product.service.ProductService;


/*
 * 
 * 지금부터 이 Controller는 Rest full 서비스를 response할 친구란느 거을 선언
 * 이 컨트롤러에서 모든 method는 절대 view를 return 할 수 없음
 * 
 * 실질적으로 Model, ModelAndView 클래스를 사용하지 않아도 됨
 */

@RequestMapping(value="/rest")
@RestController
public class ProductRestController {
	
	
	
	@Autowired
	ProductService pService;
	
	

	@RequestMapping(value="/getProduct", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ProductDTO getProduct(String p_code) {
		
		
		 ProductDTO proDTO = pService.findByPCode(p_code);
		
		return proDTO;
		
		
	}
	
	
	
	
	
	
	

	@RequestMapping(value="/getString", method=RequestMethod.GET, produces="text/json;charset=UTF-8")
	public String getString(@RequestParam(value="str"	// query로 보내는 변수명
	, required=false	// 혹 값을 보내지 않아도 오류를 내지 않음, required=false 와 defaultValue가 없으면 server는 client에게 400오류를 보내고 처리 거부
						// 절대 사용자가 만든 vo,dto에는 적용함면 안 됨
	, defaultValue="없음") String myStr) {
		
		
		if(myStr.equals("없음")) {
			
			return "http://localhost:8080/product/getString?url?str=문자열 형식으로 보내세요";
			
		}else {
			
			return "보낸 문자열은:"+ myStr;
		}
		
		
	}
	
	
	
	
	
	
	@RequestMapping(value="/getUUID", method=RequestMethod.GET, produces="text/json;charset=UTF-8")
	public String getUUID() {
		
		String strUUID = UUID.randomUUID().toString();
		return strUUID + "ㅇㅇㅇㅇ:" + strUUID.length();
		
		
	}
	
	
	
	
	

}
