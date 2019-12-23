package com.biz.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.memo.domain.MemoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes({"memoDTO", "mDTO"})
@RequestMapping(value="/session")
@Controller
public class SessionController {
	
	
	/*
	MemoDTO memoDTO;
	public SessionController() {				// 스프링에서 작동 안 됨
		memoDTO = new MemoDTO();
	}
	
	*/

	
	
	@ModelAttribute("memoDTO")					// memoDTO = new MemoDTO()
	public MemoDTO newMemoDTO() {
		return new MemoDTO();
	}
	
	@ModelAttribute("mDTO")					// mDTO = new MemoDTO()
	public MemoDTO newMDTO() {
		return new MemoDTO();
	}
	
	
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(@RequestParam("id") String str_seq,  @ModelAttribute("memoDTO") MemoDTO memoDTO, Model model) {
		
		memoDTO.setM_seq(8888);
		memoDTO.setM_auth("callor");
		memoDTO.setM_date("2019-12-03");
		
		model.addAttribute("memoDTO", memoDTO);
		
		return "insert";
			
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute("memoDTO") MemoDTO memoDTO, Model model) {
		
		log.debug("시퀀스:"+memoDTO.getM_seq());
		
		return "redirect:/memo/list";
		
		
		
		
	}
	
	
	
	
	
	
}
