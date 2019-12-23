package com.biz.memo.service;

import java.util.List;


import com.biz.memo.domain.UserDTO;

public interface UserService {

	

	public int userJoin(UserDTO userDTO); 	// 회원가입(insert), 회원가입처리를 할 때 최초의 가입을 할 때는 그 사용자는 관리자
											// 아직 테이블에 회원정보가 아무것도 없는 상태에서 회원가입을 하면 해당 사용자의 u_grade 컬럼을 "A"로 설정
											// 그 이후 갑입자는 일반 사용자로 'U'라는 문자열을 사용해 설정
	

	public boolean userIdCheck(String u_id);	// 아이디 중복검사, 만약 동일한 id가 테이블에 있으면 true return, 없으면 false return
	

	public boolean userLoginCheck(UserDTO userDTO);	// 로그인 확인, userDTO를 매개변수로 받아 DB에서 id와 password를 검사한 다음 모두 일치하면 UserDTO 객체 return, 로그인 실패하면 null return
	
	
	public int userUpdate(UserDTO userDTO);	// 회원 정보 변경 
	

	public void userOut(UserDTO userDTO);		// 회원탈퇴, 회원 정보를 삭제하는 것이 아니고 u_grade(등급) D로 설정하기(부분 update)
	




	public UserDTO getUser(String u_id);
	
	
}
