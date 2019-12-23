package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.ProductDTO;

public interface ProductDao {

	public List<ProductDTO> selectAll();

	public int insert(ProductDTO proDTO);

	public String getPCode();

	public ProductDTO findByPCode(String p_code);

	public int delete(String id);

	public int update(ProductDTO proDTO);

}
