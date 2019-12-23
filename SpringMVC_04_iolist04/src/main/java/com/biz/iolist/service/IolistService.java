package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;
import com.biz.iolist.persistence.IolistDao;

@Service
public class IolistService {
	
	
	@Autowired
	SqlSession sqlSession;
	
	IolistDao ioDao;
	
	
	@Autowired			// spring에게 ioDao가 필요하니 만들어달라는 요청
	private void getMapper() {
		ioDao = sqlSession.getMapper(IolistDao.class);
	}

	public List<IolistVO> viewAllList() {
		// TODO Auto-generated method stub
		
		
	//	IolistDao ioDao = sqlSession.getMapper(IolistDao.class);
		List<IolistVO> iolist = ioDao.viewSelectAll();
		
		
		return iolist;
	}

	public int insert(IolistDTO ioDTO) {
		// TODO Auto-generated method stub
		
	//	IolistDao ioDao = sqlSession.getMapper(IolistDao.class);
		int ret = ioDao.insert(ioDTO);
		
		return ret;
	}

	public IolistVO findBySEQ(long io_seq) {
		// TODO Auto-generated method stub
		
		IolistVO io_vo = ioDao.findBySeq(io_seq);
		return io_vo;
	}
	
	
	
	

}
