package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;

public interface IolistDao {

	List<IolistVO> viewSelectAll();

	int insert(IolistDTO ioDTO);

	IolistDTO findBySeq(long io_seq);
	
	
	

}
