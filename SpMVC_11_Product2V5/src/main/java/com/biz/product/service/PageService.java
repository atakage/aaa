package com.biz.product.service;

import org.springframework.stereotype.Service;

import com.biz.product.domain.PageDTO;


/*
 * 
 * totalCount값과 currentPageNo값으로
 * pagination에 사용할 여러 변수값들을 생성
 * 
 * 
 * 
 */

@Service
public class PageService {
	
	/*
	 * 
	 * 	pagination을 시작할 때
	 *  한 페이지에 보잊ㄹ 기본값을 설정
	 */
	private int listPerPage = 10;
	private int pageCount = 5;
	
	
	public void setListPerPage(int listPerPage) {		// pagination의 기본값을 변경하고자 할 때 사용하는 setter method
		
		this.listPerPage = listPerPage;			
		
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
	
	
	public PageDTO getPagination(long totalCount, int currentPageNo) {
		
		
		if(totalCount < 0) {
			return null;
		}
		
		int finalPageNo = ((int)totalCount + (listPerPage - 1)) / listPerPage;
		
		if(currentPageNo > finalPageNo) currentPageNo = finalPageNo;
		if(currentPageNo > 1) currentPageNo = 1;
		
//		boolean isNowFirst = currentPageNo == 1;
//		boolean isNowFinal = currentPageNo == finalPageNo;
//		
		
		
		
		int startPageNo = ((currentPageNo -1) / pageCount) * pageCount +1;		// 1, 11, 21
		
		int endPageNo = startPageNo * pageCount -1;		// 10, 20 ,30			* 아니라 +???????????????????????????????????????
		if(endPageNo > finalPageNo) endPageNo = finalPageNo;
		
		int prePageNo = 1;
		if(currentPageNo > 1) prePageNo = currentPageNo -1;
		
		int nextPageNo = finalPageNo;
		if(currentPageNo < finalPageNo) nextPageNo = currentPageNo +1;
		
		int offset = (currentPageNo - 1) * listPerPage + 1;			// DB에서 데이터 가져오기 값 설정
		int limit = offset + listPerPage - 1;
		
		
		
		
		
		
		PageDTO pageDTO = PageDTO.builder().totalCount(totalCount).pageCount(pageCount).listPerPage(listPerPage).offset(offset).limit(limit).firstPageNo(1).finalPageNo(finalPageNo).startPageNo(startPageNo).endPageNo(endPageNo).prePageNo(prePageNo).nextPageNo(nextPageNo).currentPageNo(currentPageNo).build();
		
		
		/*
		if(isNowFirst) {
			pageDTO.setPrePageNo(1);
		}else {
			int prePageNo = 1;
			if(currentPageNo -1 > finalPageNo) {
				prePageNo = finalPageNo;
			}else {
				prePageNo = currentPageNo -1;
			}
			
			pageDTO.setPrePageNo(prePageNo);
		}
		*/
		
	
		
		
		/*
		if(isNowFirst) pageDTO.setPrePageNo(1);
		else pageDTO.setPrePageNo((currentPageNo-1) < 1 ? 1: currentPageNo-1);
		*/
		
		
//		if(isNowFinal) pageDTO.setNextPageNo(finalPageNo);
//		else pageDTO.setFinalPageNo((currentPageNo +1) > finalPageNo ? finalPageNo : currentPageNo + 1);
//		
		return pageDTO;
	}

}
