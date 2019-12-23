package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.persistence.MemoDao;


// @Repository 도 사용가능

@Service
public class MemoService {
	
	
	@Autowired
	SqlSession sqlSession;
	
	MemoDao memoDao;
	

	@Autowired
	public void getMapper() {			// Service를 사용하려고 시도하면 sqlSession으로부터 MemoDao를 추출하여 memoDao 객체를 사용할 수 있도록 초기화
		
		memoDao = sqlSession.getMapper(MemoDao.class);
	}



	public List<MemoDTO> getAllList() {
		// TODO Auto-generated method stub
		
		
		List<MemoDTO> memoList = memoDao.selectAll();
		
		return memoList;
	}



	public List<MemoDTO> getSearchList(String m_subject) {
		// TODO Auto-generated method stub
		MemoDTO memoDTO = MemoDTO.builder().m_subject(m_subject).build();
		
		  
		
		return memoDao.findBySearch(memoDTO);
	}



	public int insert(MemoDTO memoDTO) {
		// TODO Auto-generated method stub
		return memoDao.insert(memoDTO);
	}



	public MemoDTO getMemo(long m_seq) {
		// TODO Auto-generated method stub
		
		MemoDTO memoDTO = memoDao.findById(m_seq);
		
		return memoDTO;
	}



	public int update(MemoDTO memoDTO) {
		// TODO Auto-generated method stub
		
		int ret = memoDao.update(memoDTO);
		return ret;
	}



	public int delete(long m_seq) {
		// TODO Auto-generated method stub
		
		return memoDao.delete(m_seq);
	}
	
	
	
	
	
	
	
}
