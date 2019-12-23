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

import lombok.extern.slf4j.Slf4j;


@Slf4j
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
	
	
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String input(Model model) {				/* 입력 form을 보여주고 데이터를 입력받도록 시작하는 절차*/
		
		return "dept/input";
		
	}
	
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String input(DeptDTO deptDTO,  Model model) {				/* 입력 form에서 데이터를 입력하고 전송(저장) 버튼을 클릭하면 데이터를 가지고 호출될 method*/
		
		
		log.debug("거래처정보 " + deptDTO.toString());
		
		
		int ret = dService.insert(deptDTO);
		
		return "redirect:/dept/list";					/* redirect:문자열로 시작되는 return
		 													view(/dept/list/list.jsp)를 호ㅜㄹ하라는 것이 아니고
		 													http://localhost:8080/context/dept/list 명령을 실행하라 메뉴에서 /dept/list 주로를 클릭하라
		 													브라우저 주소창에 ~~/dept/list를 입력하고 Enter
		 												*/
		
	}
	
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(String d_code, Model model) {
		
		
		log.debug("거래처코드: " + d_code);
		DeptDTO dDTO = dService.findByDCode(d_code);
		
		model.addAttribute("DEPT_DTO", dDTO);
		
		return null;
		
		
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String id, Model model) {
		
		int let = dService.delete(id);
		
		
		return "redirect:/dept/list";
		
		
		
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)				
	public String update(String id, Model model) {
		
		DeptDTO dDTO = dService.findByDCode(id);
		model.addAttribute("DI", dDTO);
		return "dept/input";													// 수정폼에 데이터 전달
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(DeptDTO deptDTO, Model model) {
		
		int ret = dService.update(deptDTO);
		
		
		return "redirect:/dept/view?d_code=" + deptDTO.getD_code();				// 수정된 것 보여주기 (게시글 보기)
		
	}
	
	
	

}
