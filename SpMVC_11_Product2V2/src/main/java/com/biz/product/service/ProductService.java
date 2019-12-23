package com.biz.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.product.domain.ProductDTO;
import com.biz.product.persistence.ProductDao;

@Service
public class ProductService {

	@Autowired
	SqlSession sqlSession;
	
	
	
	ProductDao proDao;
	
	
	@Autowired
	public void proDao() {
		
		this.proDao = sqlSession.getMapper(ProductDao.class);
		
	}
	
	public ProductDTO findByPCode(String p_code) {
		
		ProductDTO proDTO = proDao.findByPCode(p_code);
		
		return proDTO;
	}
	
	
	public List<ProductDTO> findByPNames(String p_name) {
		
		List<ProductDTO> proList = proDao.findByPNames(p_name);
		
		return proList;
	}

	public List<ProductDTO> selectAll() {
		// TODO Auto-generated method stub
		
		List<ProductDTO> proList = proDao.selectAll();
		return proList;
	}

	public int insert(ProductDTO proDTO) {
		// TODO Auto-generated method stub
		
		String p_code = proDao.getMaxPCode();
		String p_prefixCode = "P";
		
		
		int intPCode = 1;
		
		
		try {
			
			
			p_prefixCode = p_code.substring(0, 1);
			String p_surfixCode = p_code.substring(1);
			
			intPCode = Integer.valueOf(p_surfixCode) + 1;		// 상품테이블에 데이터가 하나도 없을 경우 intPCode를 1로 세팅한 상태로 다음 진행
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		p_code = String.format("%s%04d",p_prefixCode , intPCode);	// P0001 형식으로 코드 문자열 생성
		
		proDTO.setP_code(p_code);
		
		
		int ret = proDao.insert(proDTO);
		
		
		return ret;
	}

	public int update(ProductDTO proDTO) {
		// TODO Auto-generated method stub
		
		int ret = proDao.update(proDTO);
		return ret;
	}
	
}
