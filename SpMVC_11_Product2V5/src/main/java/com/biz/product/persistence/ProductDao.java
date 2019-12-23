package com.biz.product.persistence;

import java.util.List;

import com.biz.product.domain.PageDTO;
import com.biz.product.domain.ProductDTO;

public interface ProductDao {
	
	
	
	public List<ProductDTO> selectPagination(PageDTO pageDTO);
	public long totalCount();
	public List<ProductDTO> selectAll();
	public ProductDTO findByPCode(String p_code);
	public List<ProductDTO> findByPNames(String p_name);
	
	public String getMaxPCode();	//상품코드의 최댓값 가져오기
	
	public int insert(ProductDTO proDTO);
	public int update(ProductDTO proDTO);
	public int delete(String p_code);

}
