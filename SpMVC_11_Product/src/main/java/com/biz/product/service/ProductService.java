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
	
}
