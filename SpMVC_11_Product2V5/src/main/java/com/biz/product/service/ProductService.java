package com.biz.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.product.domain.PageDTO;
import com.biz.product.domain.ProFileDTO;
import com.biz.product.domain.ProductDTO;
import com.biz.product.persistence.FileDao;
import com.biz.product.persistence.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	SqlSession sqlSession;

	ProductDao proDao;

	FileDao fileDao;
	
	@Autowired
	FileService fService;

	@Autowired
	public void newDao() {

		this.proDao = sqlSession.getMapper(ProductDao.class);
		this.fileDao = sqlSession.getMapper(FileDao.class);

	}
	
	
	public long totalCount() {
		
		return proDao.totalCount();
		
	}
	
	public List<ProductDTO> selectPagination(PageDTO pageDTO) {
		
		List<ProductDTO> proList = proDao.selectPagination(pageDTO);
		
		
		return proList;
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

	public int insert(ProductDTO proDTO, List<ProFileDTO> upFileList) {
		// TODO Auto-generated method stub

		String p_code = proDao.getMaxPCode();
		String p_prefixCode = "P";

		int intPCode = 1;

		try {

			p_prefixCode = p_code.substring(0, 1);
			String p_surfixCode = p_code.substring(1);

			intPCode = Integer.valueOf(p_surfixCode) + 1; // 상품테이블에 데이터가 하나도 없을 경우 intPCode를 1로 세팅한 상태로 다음 진행
		} catch (Exception e) {
			// TODO: handle exception
		}

		p_code = String.format("%s%04d", p_prefixCode, intPCode); // P0001 형식으로 코드 문자열 생성

		proDTO.setP_code(p_code);

		// 파일 ㅣ스트에 상품코드를 등ㄷ록하여 상품과 파일리스트간의 연관 설정
		if (upFileList != null) {

			int nSize = upFileList.size();

			/*
			 * 
			 * for(int i = 0; i <nSize; i++) { // 상품정보에 등록할 상품코드를 파일정보에 업데이트
			 * fileDao.fileList(upFileList); upFileList.get(i).setFile_p_code(p_code);
			 * log.debug("파일정보:" + upFileList.get(i).toString());
			 * 
			 * 
			 * fileDao.fileInsert(upFileList.get(i));
			 * 
			 * 
			 * }
			 * 
			 */

			// fileDao.fileList(upFileList);
			fileDao.filesInsert(upFileList, p_code); // mybatis foreach를 활용한 동적쿼리 작성하여 한번의 connection으로 다수의 레코드에 insert
														// 수행

		}

		int ret = proDao.insert(proDTO);

		return ret;
	}
	
	public int update(ProductDTO proDTO) {
		// TODO Auto-generated method stub

		int ret = proDao.update(proDTO);

		return ret;
	}
	
	
	

	public int update(ProductDTO proDTO, List<ProFileDTO> upFileList) {
		// TODO Auto-generated method stub

		
		if(upFileList != null) {
			String p_code = proDTO.getP_code();
			fileDao.filesInsert(upFileList, p_code);
		}
		
		

		int ret = proDao.update(proDTO);

		return ret;
	}

	public String subImgDelete(String file_seq) {		// subfile 삭제
		// TODO Auto-generated method stub
		
		//이미지 파일을 삭제하고 이미지 파일이 삭제 완료되면 table에서 파일 정보를 제거
		// tbl_files에서 file_seq에 해당하는 이미지 파일을 가져와야 함
		
		
		
		
		
		ProFileDTO proFileDTO = fileDao.findByFileSeq(file_seq);
		
		String file_name = proFileDTO.getFile_upload_name();
		String p_code = proFileDTO.getFile_p_code();// 상ㅍㅁ코드
		
		
		fService.fileDelete(file_name);		// table에서 정보 제거
		
		
		fileDao.fileDelete(file_seq);
		
		return p_code;
		
	}

	public void proImgDelete(String p_code) {
		// TODO Auto-generated method stub
		
		
		ProductDTO proDTO = proDao.findByPCode(p_code);
		if (!proDTO.getP_file().isEmpty()) {

			fService.fileDelete(proDTO.getP_file());

			proDTO.setP_file(null);
			proDao.update(proDTO);
		//	pService.update(proDTO);

		}
		
	}

}
