package com.biz.esp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ESPController {

//	왜 있는지 모르는 메서드
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("BODY","ESP-LIST");
		
		return "/object/object-main";
	}
//	로그인 페이지
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		
		return "/login/login";
	}
	
//	회원가입 페이지
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		
		return "/join/join";
	}
	
//	대상별 정책 메인
	@RequestMapping(value="/object", method=RequestMethod.GET)
	public String object(Model model) {
		
		return "/object/object_main";
	}
	
//	지역별 정책 메인
	@RequestMapping(value="/area", method=RequestMethod.GET)
	public String area(Model model) {
		
		return "/area/area";
	}
	
//	소식 페이지
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public String news(Model model) {
		
		return "/news/news";
	}
	
//	정책 자료실 페이지
	@RequestMapping(value="/reference", method=RequestMethod.GET)
	public String reference(Model model) {
		
		return "/reference/reference";
	}
	
//	이용약관 페이지
	@RequestMapping(value="/infouse", method=RequestMethod.GET)
	public String infouse(Model model) {
		
		return "/infouse/infouse";
	}
	
//	개인정보처리방침 페이지
	@RequestMapping(value="/privacy", method=RequestMethod.GET)
	public String privacy(Model model) {
		
		return "/infouse/privacy";
	}
	
//	개선의견 페이지
	@RequestMapping(value="/opinion", method=RequestMethod.GET)
	public String opinion(Model model) {
		
		return "/infouse/opinion";
	}
	
}

