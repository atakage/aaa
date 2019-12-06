package com.biz.esp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/esp")
@Controller
public class AREAController {
	
	
//	지역별 정책 메인
	@RequestMapping(value="/area", method=RequestMethod.GET)
	public String area() {
		
		return "/area/area";
	}
	
	
//	서울특별시의 정책
	@RequestMapping(value="/area/seoul", method=RequestMethod.GET)
	public String areaToSeoul(Model model) {
		
		
		
		model.addAttribute("disSideSlideSW", 1);
		
		
		return "/area/areaSeoul";
	}

}
