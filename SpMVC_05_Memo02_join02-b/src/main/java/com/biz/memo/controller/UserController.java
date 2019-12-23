package com.biz.memo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.UserService;

@RequestMapping(value="/user")
@Controller
public class UserController {
	
	/* UserService 인터페이스로 uService객체를 선언하고 UserServiceImp 클래스로 초기화 생성을 수행 */
	
	@Autowired
	UserService userService;				// UserService uService = new UserService();
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
	
		UserDTO userDTO = new UserDTO();	// insert.jsp에서 spring form tag를 사용하면서 modelAttribute를 설정해 두었는데 해당 Attribute를 전달해주지 않으면
											// home을 열 때 오류가 발생, 때문에 비어있는(초기화만된) userDTO를 model에 실어 렌더링해 보냄
		
		
		
	
		
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("BODY", "JOIN");
		
		
		
		
		return "user/insert";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult bResult, Model model) {
		
		
		
		if(bResult.hasErrors()) {
			
				return"user/insert";
				
		}else {
		

			int ret = userService.userJoin(userDTO);
			return "redirect:/memo/list";
		}
		
		
	}
	
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage(Model model, HttpSession httpSession) {
		
		UserDTO userDTO = (UserDTO)httpSession.getAttribute("userDTO");					// get으로 가져오는 userDTO의 값 ???
		
		
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("TITLE", "회원정보 수정");
		
		
		return "user/insert";
	}
	
	

}
