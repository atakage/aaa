package com.biz.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.domain.HobbyDTO;
import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.MemoService;
import com.biz.memo.service.UserService;

@RequestMapping(value="/user")
@Controller
public class UserController {
	
	/* UserService 인터페이스로 uService객체를 선언하고 UserServiceImp 클래스로 초기화 생성을 수행 */
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
	
		UserDTO userDTO = UserDTO.builder().build(); // UserDTO userDTO = new UserDTO();
		
		List<HobbyDTO> hList = userService.getHobbyList();			// 취미리스트
		
		model.addAttribute("HO_LIST", hList);
	/*	String[] strH = new String[]{hList.get(0).getH_code(), hList.get(3).getH_code()};  */
		
		
	/*	userDTO.setU_hobby(strH); */
		
		model.addAttribute("userDTO", userDTO);
		
		
		return "user/insert";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserDTO userDTO, Model model) {
		
		
		int ret = userService.userJoin(userDTO);
		return "redirect:/memo/list";
		
	}
	
	

}
