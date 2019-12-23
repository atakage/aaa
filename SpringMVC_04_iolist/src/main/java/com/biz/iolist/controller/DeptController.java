package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.service.DeptService;


@RequestMapping(value="/dept")
@Controller
public class DeptController {
	
	@Autowired		// @Inject
	DeptService dService;
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)			// /dept(리퀘매핑class) + /list(리퀘매핑method) path로 request 했을 때 list() method가 호출됨
	public ModelAndView list(Model model) {
		
		ModelAndView mView = new ModelAndView();			// Model(ui.Model) 클래스와 같은 역할을 수행하는 spring 클래스
															// 사용법이 조금 다른 형식
															// 여기에는 view와 객체를 동시에 담아 Despatcher에게 객체를 리턴해주는 형식
															// Model은 객체만 담고, view는 문자열을 return하는 방식으로 사용
		
		List<DeptDTO> deptList = dService.getAllList();
		
		mView.setViewName("/dept/list");			// return "/dept/list"
		mView.addObject("DEPTLIST", deptList);		// model.addAttribute("DEPTLIST", deptList)
		
		return mView;		// return String이 아닌 ModelAndView 사용
		
		
	}
	
	
	

}
