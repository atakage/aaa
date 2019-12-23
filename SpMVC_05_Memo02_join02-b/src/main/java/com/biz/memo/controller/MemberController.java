package com.biz.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.UserService;



/* Controller에서 객체(리스트)를 view로 보내는 방법 
 * 
 * Model(ModelAndView).addAttribute()
 * 
 * 
 * SessionAttributes() ModelAndAttribute() 설정 후 Model에 담기
 * 
 * HttpSession.setAttribute()에 담기
 * 
 * 
 * Model: 일회용 데이터 Controller >> view로 보내기만을 위한 데이터
 * Model에 담긴 데이터를 다시 server로 보내려면 input tag에 값을 담아서 다시 POST로 전송
 * 
 * SessionAttributes + Model: 일회용데이터이면서 session 유지되는 데이터, input view에서 Spring form tag에 값을 담으면 이후에 자유롭게 서버로 전송할 수 있음
 * input, update 코딩을 간편하게 사용하는 용도, spring에서는 SessionAttribute일 경우 gabage Collection이 적용
 * 
 * HttpSession: 주로 login과 관련된 데이터를 유지하기 위한 용도, 특별히 시간설정을 하거나 값을 remove하거나 서버가 멈출 때까지 그 값을 유지하고 모든 controller,
 * 	모든 view에서 값을 참조할 수 있음 서버의 메모리 공간을 많이 차지하여 서버 성능에 문제를 일으키기도 함, GC(Gabage Collection)을 적용할 수 없음
 * 	표준 HTTP프로토콜에 정의된 규격을 사용
 * 
 * 
 * */


@RequestMapping(value="/member")
@Controller							
public class MemberController {
	
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		
		
		
		
		return null;
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam(value="LOGIN_MSG", required = false, defaultValue= "0")  String msg, Model model) {
		
		
		model.addAttribute("LOGIN_MSG", msg);
		model.addAttribute("BODY", "LOGIN");
		return "member/login";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String BODY, @ModelAttribute UserDTO userDTO, Model model, HttpSession httpSession) {	// DB에서 데이터를 가져온 사용ㅈ 정보
		
		
		
		
		boolean loginOk = userService.userLoginCheck(userDTO);
		
		if(loginOk == true) {
			
			httpSession.setMaxInactiveInterval(10*60);
			
			
		 userDTO	= userService.getUser(userDTO.getU_id());
			httpSession.setAttribute("userDTO", userDTO);	// DB로부터 사용자 정보 가져옴
			
		}else {
			
			
			
			httpSession.removeAttribute("userDTO");
			model.addAttribute("LOGIN_MSG", "FAIL");
			return "redirect:/member/login";
		}
		
		model.addAttribute("BODY", BODY);
			
			/*
			if(userDTO.getU_id().equalsIgnoreCase(getUserDTO.getU_id()) && userDTO.getU_password().equals(getUserDTO.getU_password())) {	//로그인한 사용자 ID와 password가 DB정보와 이일치하는지 검사
				
				
			}else {
				httpSession.removeAttribute("userDTO");
			}
		*/
		
		return "redirect:/";
		
	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logOut(HttpSession httpSession) {
		
		
		
		httpSession.setAttribute("userDTO", null);
		httpSession.removeAttribute("userDTO");
		
		
		
		return "redirect:/";
	}
	
	
	
	

}
