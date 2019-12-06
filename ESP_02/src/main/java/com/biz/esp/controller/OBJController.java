package com.biz.esp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/esp")
@Controller
public class OBJController {
	
	
	
	
//	대상별 정책 메인
	@RequestMapping(value="/object", method=RequestMethod.GET)
	public String object(Model model) {
		
		return "/object/object_main";
	}
	

// 청년 추가고용 장려금 지원사업 페이지
	
	@RequestMapping(value="/object/ym1", method=RequestMethod.GET)
	public String objectToYm1() {
		
		return "/object/object_ym1";
	}

}
