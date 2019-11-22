package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.student.domain.StudentDTO;

@Service
public class StudentService {
	
	
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
