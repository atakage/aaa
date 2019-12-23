package com.biz.product.controller;

import java.security.spec.PSSParameterSpec;
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

import com.biz.product.domain.ProductDTO;
import com.biz.product.service.FileService;
import com.biz.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {

	
	@Autowired
	ProductService pService;
	
	@Autowired
	FileService fService;
	
	
	
	
	//@ResponseBody
	@RequestMapping(value="/plist", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String getPList(Model model) {
		
		
		
		
		 List<ProductDTO> proList = pService.selectAll();
		
		 
		 model.addAttribute("PLIST", proList);
		 
		 
		return "home";
		
		
	}
	

	
	
	
	
	@ResponseBody
	@RequestMapping(value="/plist/name", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<ProductDTO> getNames(String p_name) {
		
		
		 List<ProductDTO> proList = pService.findByPNames(p_name);
		
		return proList;
		
		
	}
	
	
	
	
	
	
	/*
	 * 
	 * 결과물을 view(.jsp)로 전환하지 않고 문자열 그대로 또는 객체(vo, dti)를 json형태로 변경하여 클라이언트에게 response를 수행하는 기능
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
	 * 문자열이나 객체에 담긴 데이터를 그대로 client에게 전송, responsebody를 사용할 때는 꼭 produces를 설정한느 것이 좋음
	 * 특히 한글 데이터를 response 할 때는 반드시!(charset=UTF-8)
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value="/getString", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public String getString(@RequestParam(value="str"	// query로 보내는 변수명
	, required=false	// 혹 값을 보내지 않아도 오류를 내지 않음, required=false 와 defaultValue가 없으면 server는 client에게 400오류를 보내고 처리 거부
						// 절대 사용자가 만든 vo,dto에는 적용함면 안 됨
	, defaultValue="없음") String myStr) {
		
		
		if(myStr.equals("없음")) {
			
			return "http://localhost:8080/product/getString?url?str=문자열 형식으로 보내세요";
			
		}else {
			
			return "보낸 문자열은:"+ myStr;
		}
		
		
	}
	
	
	
	
	
	//product 
	
	@ResponseBody
	@RequestMapping(value="/pname", method=RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getPName(String p_code) {
		
		
		 ProductDTO proDTO = pService.findByPCode(p_code);
		
		//	return proDTO.getP_name();
		
		 return "<h1>" + proDTO.getP_name() +"</h1>";
		
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/oprice", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String getOPrice(String p_code) {
		
		
		 ProductDTO proDTO = pService.findByPCode(p_code);
		
		return proDTO.getP_oprice()+"";
		
		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/iprice", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String getIPrice(String p_code) {
		
		
		 ProductDTO proDTO = pService.findByPCode(p_code);
		
		return proDTO.getP_iprice()+"";
		
		
	}
	
	
	
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String input(@ModelAttribute ProductDTO proDTO, @RequestParam("u_file") MultipartFile u_file) {
		
		
		int ret= 0 ;
		
		log.debug("상품정보 입력:" + proDTO.toString());
		log.debug("업로드한 파일:" + u_file.getOriginalFilename());
		
		
		
		
		
		if(!u_file.isEmpty()) { //파일을 선택하지 않았으면 파일에 관한 처리를 수행하지 않음(업로드할 파일을 선택했을 때만 수행)
			
			
			
			// update 수행할 때 이미 업로드된 파일이 있으면 기존 파일을 삭제하고 새로운 파일을 업로드 해야 하므로 p_file 변수를 검사하여 값이 있으면 파일 삭제
			if(proDTO.getP_file() != null) {
				
			
				fService.fileDelete(proDTO.getP_file());
				
			}
			
			
			
			/*
			 * web에서 파일이 전송되어 오면
			 * fService.fileUp() method에게 파일을 어딘가에 저장해 달라고 요청
			 *  
			 */
			String upFileName = fService.fileUp(u_file);
			
			if(upFileName != null) {
				
				/*
				 * 
				 * 
				 */
				proDTO.setP_file(upFileName);	// 정상적으로 저장이 완료되어으면, 파일이름을 DTO의 p_file 변수에 저장
			}
			
			
		}
		
		
		
		
		if(proDTO.getP_code().isEmpty()) {
			log.debug("새로운 상품 등록");
			ret = pService.insert(proDTO);
		}else {
			log.debug("기존 상품 변경");
			ret=  pService.update(proDTO);
		}
		
		return "redirect:/plist";
	}
	
	
	@RequestMapping(value="/imgDelete", method=RequestMethod.GET)
	public String imgDelete(String p_code) {
		
		ProductDTO proDTO = pService.findByPCode(p_code);
		if(!proDTO.getP_file().isEmpty()) {
			
			fService.fileDelete(proDTO.getP_file());
			
			proDTO.setP_file(null);
			pService.update(proDTO);
			
		}
		return "redirect:/plist";
	}
	
	
	
}
