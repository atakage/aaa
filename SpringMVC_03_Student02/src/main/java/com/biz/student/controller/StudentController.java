package com.biz.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.student.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudentController {
	
	
	@RequestMapping(value="/student/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		
		model.addAttribute("BODY", "STUDENT-LIST");
		
		
		
		
		
		
		
//		return null;			// "/student/list.jsp"
		
		
		return "home";
		
	}

}
