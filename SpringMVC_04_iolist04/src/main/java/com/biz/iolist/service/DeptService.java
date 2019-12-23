package com.biz.iolist.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.persistence.DeptDao;

@Service
public class DeptService {

	
	@Autowired
	SqlSession sqlSession;
	
	DeptDao deptDao;
	
	
	@Autowired													// service클래스에서 deptDao가 필요할 때 spring이 자동으로 이 메서드를 호출하여 deptDao를 초기화 생성
																
	public void getDeptDaoMapper() {
		deptDao = sqlSession.getMapper(DeptDao.class);
		
	}
	
	public List<DeptDTO> getAllList(){
		
		
		//DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		
		List<DeptDTO> deptList = deptDao.selectAll();
		return deptList;
		
	}


	public int insert(DeptDTO deptDTO) {
		
		
		
		//DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		
		
		
		String d_code = deptDao.getDCode();				// D0900
		
		String d_code_num = d_code.substring(1);				// 0900
		int int_dcode = Integer.valueOf(d_code_num) +1;			// 0901
		
		
		d_code = d_code.substring(0, 1);				// 'D'
		d_code += String.format("%04d", int_dcode);		// D + 0901
		
		
		deptDTO.setD_code(d_code);
		
		
		
		int ret = deptDao.insert(deptDTO);
		return ret;
		
		
		// TODO Auto-generated method stub
		
	}


	public DeptDTO findByDCode(String d_code) {
		// TODO Auto-generated method stub
		
		//DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		
		DeptDTO dDTO = deptDao.findByDCode(d_code);
		
		return dDTO;
	}


	public int delete(String d_code) {
		// TODO Auto-generated method stub
		
		
		//DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		int ret = deptDao.delete(d_code);
		
		return ret;
		
		
	}


	public int update(DeptDTO deptDTO) {
		// TODO Auto-generated method stub
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		int ret = deptDao.update(deptDTO);
		
		return ret;
	}


	public List<DeptDTO> selectNameSearch(String strText) {
		// TODO Auto-generated method stub
		
			List<DeptDTO> deptList = null;
		
			DeptDTO deptDTO = deptDao.findByDCode(strText);			
			
			if(deptDTO != null) {															// 매개변수로 전달받은 strText문자열을 거래처코드로 조회해보고 조회가 되면 해당 거래처 정보를
				//	리스트에 담아서 리턴
				deptList = new ArrayList<DeptDTO>();
				deptList.add(deptDTO);
			}else {																// 조회가 되지 않으면 거래처 이름으로 조회하여 리스트 리턴
				deptList = deptDao.findByDname(strText);
			}
			
			return deptList;
		
	
	}
	
	
}
