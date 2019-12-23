package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.ProductDTO;
import com.biz.iolist.persistence.ProductDao;


@Service
public class ProductService {
	
	
	@Autowired
	SqlSession sqlSession;
	
	
	

	public List<ProductDTO> getAllList() {
		// TODO Auto-generated method stub
		ProductDao productDao = sqlSession.getMapper(ProductDao.class);
		
		List<ProductDTO> proList = productDao.selectAll();
		
		
		
		return proList;
	}




	public int insert(ProductDTO proDTO) {
		// TODO Auto-generated method stub
		
		ProductDao productDao = sqlSession.getMapper(ProductDao.class);
		
		String p_code = productDao.getPCode();
		
		String p_code_num = p_code.substring(1);
		
		int int_pcode = Integer.valueOf(p_code_num)+1;
		
		p_code = p_code.substring(0,1);
		p_code += String.format("%04d", int_pcode);
		
		
		proDTO.setP_code(p_code);
		
		
		
		int ret = productDao.insert(proDTO);
		
		
		return ret;
	}




	public ProductDTO findByPCode(String p_code) {
		
		
		ProductDao productDao = sqlSession.getMapper(ProductDao.class);
		
		ProductDTO proDTO = productDao.findByPCode(p_code);
		
		// TODO Auto-generated method stub
		return proDTO;
	}




	public int delete(String id) {
		// TODO Auto-generated method stub
		
		
		ProductDao productDao = sqlSession.getMapper(ProductDao.class);
		
		int ret = productDao.delete(id);
		return ret;
	}




	public int update(ProductDTO proDTO) {
		// TODO Auto-generated method stub
		
		ProductDao productDao = sqlSession.getMapper(ProductDao.class);
		
		int ret = productDao.update(proDTO);
		return ret;
	}

}
