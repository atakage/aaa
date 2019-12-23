package com.biz.memo.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.biz.memo.domain.UserDTO;


public interface UserDao {
	
	
	
	

	
	
	
	public int userCount();		// 회원 테이블의 전체 회원수를 조회하는 method



	public int insert(UserDTO userDTO);







	public UserDTO findById(@Param("u_id") String u_id);
	
	
		

}
