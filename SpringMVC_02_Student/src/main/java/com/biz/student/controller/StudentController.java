package com.biz.student.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.student.domain.StudentDTO;
import com.biz.student.service.AnnService;
import com.biz.student.service.HomeService;
import com.biz.student.service.StudentService;


/*
 * @Controller
 * Tomcat, Spring container에 이 클래스의 List를 추가하고 request 요청에 대비
 * 
 * 
 */


@Controller
public class StudentController {
	
	//@Autowired
	
	@Inject					// java EJB 방식
	StudentService ss;
	
	@Autowired				// Spring 방식
	HomeService hService;
	
	@Autowired
	AnnService aService;
	
	
	public StudentController() {
		// TODO Auto-generated constructor stub
		ss = new StudentService();
	}
	

	@RequestMapping(value = "input", method = RequestMethod.GET)
	public String input() {		//input form에 데이터를 입력한 후 전송하면 데이터를 수신할 method
		// 매개변수로 설정된 StudentDTO stDTO는 form의 input box에 설정된 name과 같은 변수명을 필드로 갖는 DTO
		
		// 별다른 setter조치 없이 Spring은 자동으로 form의 input box에 설정된 name값과 일치하는 정보를 검사하여 자동으로
		// DTO에 전달받은 값을 setting하여 stDTO에 담아줌
		
		// form에서 전달받은 모든 데이터는 기본적으로 String형, 이때 st_grade는 int형으로 필드변수에 선언이 되어 있는데
		// 문자열ㄹ로 전달받은 데이터를 int형으로 Integer.valueof() method를 이용하여 숫자형으로 변환을 시도할 것(spring framework에서)
		
		// 만약 st_grade input box에 값을 입력하지 않고 전송을 누르면 해당 변수에 담긴 값은 ""이거나 null일 것
		// (NumberFormatException)
		
		// 톰캣은 web browse에 400 오류를 보내 값이 잘못 전달되었다는 것을 알려줌

		
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
		
		ss.viewStudent();
		hService.viewHome();
		aService.viewAnn();
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
