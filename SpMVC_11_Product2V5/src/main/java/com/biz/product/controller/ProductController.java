package com.biz.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.product.domain.PageDTO;
import com.biz.product.domain.ProFileDTO;
import com.biz.product.domain.ProductDTO;
import com.biz.product.service.FileService;
import com.biz.product.service.PageService;
import com.biz.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {

	@Autowired
	ProductService pService;

	@Autowired
	FileService fService;
	
	@Autowired
	PageService pageService;

	// @ResponseBody
	@RequestMapping(value = "/plist", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String getPList(Model model, @RequestParam(value="currentPageNo", required=false, defaultValue="1") int currentPageNo) {

		//List<ProductDTO> proList = pService.selectAll();
		PageDTO pageDTO = pageService.getPagination(100,currentPageNo);
		List<ProductDTO> proList = pService.selectPagination(pageDTO);
		
		model.addAttribute(pageDTO);		// attribute의 이름을 지정하지 않으면 객체의 이름과 같은 문자열로 자동 지정됨
		model.addAttribute("PLIST", proList);

		return "home";

	}

	@ResponseBody
	@RequestMapping(value = "/plist/name", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<ProductDTO> getNames(String p_name) {

		List<ProductDTO> proList = pService.findByPNames(p_name);

		return proList;

	}

	/*
	 * 
	 * 결과물을 view(.jsp)로 전환하지 않고 문자열 그대로 또는 객체(vo, dti)를 json형태로 변경하여 클라이언트에게
	 * response를 수행하는 기능
	 * 
	 */
//	@ResponseBody
//	@RequestMapping(value="/getProduct", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
//	public ProductDTO getProduct(String p_code) {
//		
//		
//		 ProductDTO proDTO = pService.findByPCode(p_code);
//		
//		return proDTO;
//		
//		
//	}

	/*
	 * 
	 * 문자열이나 객체에 담긴 데이터를 그대로 client에게 전송, responsebody를 사용할 때는 꼭 produces를 설정한느 것이
	 * 좋음 특히 한글 데이터를 response 할 때는 반드시!(charset=UTF-8)
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getString", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String getString(@RequestParam(value = "str" // query로 보내는 변수명
			, required = false // 혹 값을 보내지 않아도 오류를 내지 않음, required=false 와 defaultValue가 없으면 server는 client에게
								// 400오류를 보내고 처리 거부
								// 절대 사용자가 만든 vo,dto에는 적용함면 안 됨
			, defaultValue = "없음") String myStr) {

		if (myStr.equals("없음")) {

			return "http://localhost:8080/product/getString?url?str=문자열 형식으로 보내세요";

		} else {

			return "보낸 문자열은:" + myStr;
		}

	}

	// product

	@ResponseBody
	@RequestMapping(value = "/pname", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getPName(String p_code) {

		ProductDTO proDTO = pService.findByPCode(p_code);

		// return proDTO.getP_name();

		return "<h1>" + proDTO.getP_name() + "</h1>";

	}

	@ResponseBody
	@RequestMapping(value = "/oprice", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String getOPrice(String p_code) {

		ProductDTO proDTO = pService.findByPCode(p_code);

		return proDTO.getP_oprice() + "";

	}

	@ResponseBody
	@RequestMapping(value = "/iprice", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String getIPrice(String p_code) {

		ProductDTO proDTO = pService.findByPCode(p_code);

		return proDTO.getP_iprice() + "";

	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute ProductDTO proDTO // 다수의 파일 업로드 정보를 수신

			, MultipartHttpServletRequest u_files, MultipartFile u_file) throws Exception {

		/*
		 * MultipartHttpServletRequest는 여러개의 MultipartFile을 포함하고 있는 객체리스트
		 * 
		 */

		for (MultipartFile f : u_files.getFiles("u_files")) {

			log.debug("파일이름: " + f.getOriginalFilename()); // getFiles("input tage의 name 변수명")

		}
		
		
		try {
			
			String profileImage = fService.fileUp(u_file);
			
			if(profileImage != null) {
				if(proDTO.getP_file() != null) {
					fService.fileDelete(proDTO.getP_file());
				}
				proDTO.setP_file(profileImage);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("대표이미지 업로드 에러:" + e.getMessage());
		}
		
		

		List<ProFileDTO> upFileList = fService.filesUp(u_files);
		
		
		

		
		
		
		

		/*
		 * 1개 파일을 업로드할 때 MultipartFile로 업로드를 수행하고 2개 이상의 파일을 업로드할 때는 MultipartRequest
		 * 객체로 파일을 받아서 처리를 수행
		 */

		int ret = 0;
		
		
		


		if (proDTO.getP_code().isEmpty()) {
			log.debug("새로운 상품 등록");
			ret = pService.insert(proDTO, upFileList);			// 상품 정보와 파일리스트를 insert() method에 전달
			
			
		} else {
			log.debug("기존 상품 변경");
			ret = pService.update(proDTO, upFileList);		// 변경할 상품정보와 파일리스틀ㄹ update() method에 전달
		}

		return "redirect:/plist";

	}

	@RequestMapping(value = "/proImgDelete", method = RequestMethod.GET)
	public String imgDelete(String p_code) {				// 대표이미지 삭제

		pService.proImgDelete(p_code);
		return "redirect:/plist";
	}
	
	@RequestMapping(value="/subImgDelete", method=RequestMethod.GET)
	public String subImgDelete(String file_seq) {
		
		
		 pService.subImgDelete(file_seq);
		
		
		
		
		
		return "redirect:/plist";
		
	}

}
