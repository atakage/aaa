package com.biz.esp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.AreaDTO;
import com.biz.esp.persistence.AreaDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AreaService {
	
	@Autowired
	SqlSession sqlSession;
	
	AreaDao areaDao;
	
	
	@Autowired
	public void getAreaMapper() {
		areaDao = sqlSession.getMapper(AreaDao.class);
	}

	public List<AreaDTO> getSeoulContent(int startIndex) {
		// TODO Auto-generated method stub
	
		System.out.println("sql에서 startindex:"+startIndex);
		 
		 List<AreaDTO> areaList = areaDao.selectSeoulContent(startIndex);
		
		
		
		return areaList;
	}

	public List<AreaDTO> getAreaContent(int startIndex, String pa_acode) {
		// TODO Auto-generated method stub
		
		
		 List<AreaDTO> areaList = areaDao.selectAreaContent(startIndex, pa_acode);
		
		return areaList;
	}

	public AreaDTO viewAreaContent(String pa_acode) {
		// TODO Auto-generated method stub
		
		AreaDTO areaDTO = areaDao.selectAreaView(pa_acode);
		
		return areaDTO;
	}

}
