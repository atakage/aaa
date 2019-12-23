package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.biz.memo.domain.UserDTO;

import com.biz.memo.persistence.UserDao;



/*
 * interface를 imp하여 생성한 클래스에 @Service를 붙여주면 @Autowired를 수행할 때
 * Interface 객체 형식으로 코드를 작성하면 자동으로 해당 객체를 가져와서 초기화해줌
 * 
 * 
 * */


@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	SqlSession sqlSession;
	
	UserDao userDao;

	@Autowired
	public void newUserDao() {
		
		userDao = sqlSession.getMapper(UserDao.class);
		
		
	}
	
	@Override
	public int userJoin(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		/* 최초로 등록되는 사용자는 관리자
		 * u_grade 값을 'A'로 세팅을 함
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		if(userDao.userCount() > 0) {					// tbl_user 테이블에 데이터가 하나도 없으면 회원정보 DTO의 u_grade 필드 변수에 문자열 "A"를 저장하고 그렇지 않으면
																	// "U"를 저장해 수행
			
			userDTO.setU_grade("U");
		}else {
			
			userDTO.setU_grade("A");
		}
		int ret = userDao.insert(userDTO);
		
		String[] strHobby = userDTO.getU_hobby();
		
		for(String s : strHobby) {
			
			UserHobbyDTO uh = UserHobbyDTO.builder().uh_id(userDTO.getU_id()).uh_code(s).build();
			userDao.uHInsert(uh);
			
		}
		
		
		
		return 0;
	}

	@Override
	public boolean userIdCheck(String u_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userLoginCheck(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		String inU_id = userDTO.getU_id();
		String inU_pass = userDTO.getU_password();
		
		
		UserDTO userRDTO = userDao.findById(inU_id);		// 암호화를 대비한 코드로 작성 id를 매개변수로 보내고 id로 조회를 하여
		
		
		
		if(userRDTO == null) {
			return false;
		}
		
		
		String sU_id = userRDTO.getU_id();
		String sU_pass = userRDTO.getU_password();
		
		if(sU_id.equalsIgnoreCase(inU_id)&&sU_pass.equalsIgnoreCase(inU_pass)) {
			
		//	userDTO = userRDTO;			// java method에서 객체를 매개변수로 받은 후 각 필드 변수들을 개별적으로 변경하면 파라미터도 주입한 원본의 변수값들이 변경됨
											// 그러나 객체 = 다른객체, 또논 객체 = new 클래스() 형식으로 자체를 변경해 버리면 파라미터로 주입한 원ㅂㄴ은 변경되지 않음
			
			userDTO.setU_grade(userRDTO.getU_grade());
			
			return true;
			
		}else {
			return false;
		}
		
		
	
	}

	@Override
	public int userUpdate(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void userOut(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HobbyDTO> getHobbyList() {
		// TODO Auto-generated method stub
		return userDao.selectAllHobby();
	}

	@Override
	public UserDTO getUser(String u_id) {
		// TODO Auto-generated method stub
		return userDao.findById(u_id);
	}
	

	
	
	
}
