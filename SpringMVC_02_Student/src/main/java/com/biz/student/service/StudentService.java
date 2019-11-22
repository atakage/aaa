package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.student.controller.StudentController;
import com.biz.student.domain.StudentDTO;


public class StudentService {
	
	
	private String st_name;
	private String st_dept;
	
	
	public StudentService() {
		// TODO Auto-generated constructor stub
		
		
		
	}
	
	public StudentService(String st_name, String st_dept) {
		// TODO Auto-generated constructor stub
		
		this.st_name = st_name;
		this.st_dept = st_dept;
	}
	
	public void viewStudent() {
		
		System.out.println(this.st_name);
		System.out.println(this.st_dept);
		
	}
	
	public List<StudentDTO> stdList(){
		
		List<StudentDTO> stdList = new ArrayList<StudentDTO>();
		
		StudentDTO dto = new StudentDTO();
		
		dto.setSt_num("0001");
		dto.setSt_name("hong");
		dto.setSt_dept("com");
		dto.setInt_grade(3);
		dto.setSt_tel("010");
		
		stdList.add(dto);
		
		
		dto = new StudentDTO();
		dto.setSt_num("0002");
		dto.setSt_name("ong");
		dto.setSt_dept("com");
		dto.setInt_grade(2);
		dto.setSt_tel("010");
		
		stdList.add(dto);
		
		
		dto = new StudentDTO();
		dto.setSt_num("0003");
		dto.setSt_name("ng");
		dto.setSt_dept("science");
		dto.setInt_grade(1);
		dto.setSt_tel("010");
		
		stdList.add(dto);
		
		return stdList;
		
	}

}
