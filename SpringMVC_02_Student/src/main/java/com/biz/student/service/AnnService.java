package com.biz.student.service;

import org.springframework.stereotype.Service;

// @Bean // 종류에 관계없이 사용(JDK에서 제공하는 클래스에서 사용), xml에 <bean>으로 설정할 클래스 선언과 생성을 대신하는 Annotation
// @Service는 MVC 패턴에서 Service 클래스에 사용

//@Component			// 종류에 관계없이 사용(사용자가 작성한 클래스에서 사용)

@Service
public class AnnService {
	
	
	
	public void viewAnn() {
		System.out.println("대한민국 만세");
		System.out.println("Republic of Korea");
		
		
	}
	

}
