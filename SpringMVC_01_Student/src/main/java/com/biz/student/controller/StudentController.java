package com.biz.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.student.domain.StudentDTO;
import com.biz.student.service.StudentService;


/*
 * @Controller
 * Tomcat, Spring container에 이 클래스의 List를 추가하고 request 요청에 대비
 * 
 * 
 */


@Controller
public class StudentController {
	
	@Autowired
	StudentService ss;
	
	/*
	public StudentController() {
		// TODO Auto-generated constructor stub
		ss = new StudentService();
	}
	*/

	@RequestMapping(value = "input", method = RequestMethod.GET)
	public String input() {

		
		return "student/input"; //WEB-INF/views/student/input.jsp 파일을 열어 browser로 전송
	}
	
	@RequestMapping(value = "input", method = RequestMethod.POST)
	public String input(StudentDTO dto ,Model model) {

		System.out.println(dto.toString());
		model.addAttribute("dto", dto);
		return "student/view"; 
	}
	
	

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search() {
		return "student/search";
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view() {
		return "student/view";
	}
	
	@RequestMapping(value = "viewList", method = RequestMethod.GET)
	public String view(Model model) {
		
		List<StudentDTO> stdList = ss.stdList();
		
		model.addAttribute("stdList", stdList);
		
		return "student/viewList";
	}

}
