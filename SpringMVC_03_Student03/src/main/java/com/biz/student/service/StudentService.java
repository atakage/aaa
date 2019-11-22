package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.student.domain.StudentDTO;


/*
 * 
 * 
 * @Component Annotation을 대신해서 의미있는 이름으로 설정
 * 
 * spring bean으로 클래스를 등록
 * component-scan base-package에 service package를 등록 설정
 * 
 * 
 */
@Service
public class StudentService {
	
	public List<StudentDTO> getStdList(){
		
		
		List<StudentDTO> stdList = new ArrayList<StudentDTO>();
		
		
		StudentDTO stDTO = new StudentDTO();
		
		stDTO = StudentDTO.builder().st_num("2019001").st_name("김씨").st_dept("경제학과").st_grade(1).build();
		stdList.add(stDTO);
		
		stDTO = StudentDTO.builder().st_num("2019002").st_name("박씨").st_dept("영문학과").st_grade(2).build();
		stdList.add(stDTO);
		
		stDTO = StudentDTO.builder().st_num("2019003").st_name("이씨").st_dept("컴퓨터공학과").st_grade(4).build();
		stdList.add(stDTO);
				
				
				
				
		
		
		 return stdList;
		
		//return null;
		
	}
 	
	
	
	
}
