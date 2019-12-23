package com.biz.esp.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.esp.domain.AreaDTO;

public interface AreaDao {

	int selectSeoulListCnt();

	List<AreaDTO> selectSeoulContent(int startIndex);

	int selectAreaListCnt(String pa_acode);

	List<AreaDTO> selectAreaContent(@Param("startIndex") int startIndex, @Param("pa_acode")String pa_acode);

	AreaDTO selectAreaView(String pa_acode);

}
