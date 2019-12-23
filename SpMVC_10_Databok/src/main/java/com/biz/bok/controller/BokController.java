package com.biz.bok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.bok.domain.BokDetailVO;
import com.biz.bok.domain.BokListVO;
import com.biz.bok.domain.BokSearchDTO;
import com.biz.bok.service.BokDetailService;
import com.biz.bok.service.BokListService;
import com.biz.bok.service.CodeService;

import lombok.extern.slf4j.Slf4j;





/*
 * 
 * 기억장치 어딘가에 bokSearchDTO라는 객체 저장공간을 만들고
 * 그 공간을 session에 등록하여
 * controller, jsp에서 공통으로 접근할 수 있도록 설정
 * 
 * 
 * session에 등록한다는 것은 서버의 기억장치에 저장하여 클라이언트(web browser)와 server간 연결이 끊기더라도 데이터를 참조할 수 있도록
 * 하는 것
 * 
 * 
 * HTTP 프로토콜의 성질
 * web form에 입력된 data ==> server 전송되고나면 그 데이터는 공중으로 사라짐
 * 
 * server => web browser에 어떤 결과를 보내고 나면 마찬가지로 데이터는 사라지고, 연결도 모두 종료
 * 
 *  하지만 web 과 server간 어떤 데이터를 일정하게 유지하고 싶을 때가 있음(login)
 *  
 *  이럴 때는 session이라는 공간에 데이터를 저장해 두면 web == server가 이 데이터에 접근 가능
 *  
 *  session은 web과 server가 공유하는 데이터
 * 
 * 
 * 
 * 
 * 
 */


@Slf4j
@SessionAttributes("bokSearchDTO")
@Controller
public class BokController {
	
	
	@Autowired
	CodeService codeService;
	
	@Autowired
	BokListService blService;
	
	
	@Autowired
	BokDetailService bdService;
	/*
	 *  SessionAttribute에 등록된 객체변수는 현재 cotroller 내에서 생성하는 method가 반드시 있어야 함
	 */
	
	@ModelAttribute("bokSearchDTO")
	public BokSearchDTO bokSearchDTO() {
		
		
//		BokSearchDTO bkDTO = BokSearchDTO.builder().searchWrd("고용정책").build();
		
		
		return blService.getDefaultSearch();
		
	}
	
	
	/*
	 * 
	 * web에서 search를 request하면 매개변수 bokSearchDTO를 어딘가로부터 받아야하는데
	 * 최초에는 아무도 이 값이 없는 상태로 search를 호출
	 * 
	 * 이럴 경우 bokSearchDTO()가 자동으로 호출되어 bokSearchDTO객체를 사용할 수 있도록 초기화 작업함
	 *  
	 * 
	 * 
	 */
	
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(Model model, @ModelAttribute("bokSearchDTO") BokSearchDTO bokSearchDTO) {
		
		
		
		model.addAttribute("bokSearchDTO", bokSearchDTO);
		model.addAttribute("SeMaps", codeService.getSelectMaps());
		
		
		
		return "home";
		
	}
	
	
	
	
	@RequestMapping(value="/search", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public String search(String strDummy, Model model, @ModelAttribute("bokSearchDTO") BokSearchDTO bokSearchDTO) {
		
		
		//bokSearchDTO.setSearchWrd("청년정책");
		
		
		model.addAttribute("bokSearchDTO", bokSearchDTO);
		model.addAttribute("SeMaps", codeService.getSelectMaps());
		
		
		List<BokListVO> bokList = blService.getRestResult(bokSearchDTO);
		
	
		
		log.debug("결과물"+bokList);
		
		
		model.addAttribute("BOKLIST", bokList);
		
		
		return "home";
		
		
		
	}
	
	
	
	

	@RequestMapping(value="/searchAPI", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public String searchAPI(String strDummy, Model model, @ModelAttribute("bokSearchDTO") BokSearchDTO bokSearchDTO) {
		
		
		//bokSearchDTO.setSearchWrd("청년정책");
		
		
		model.addAttribute("bokSearchDTO", bokSearchDTO);
		model.addAttribute("SeMaps", codeService.getSelectMaps());
		
		
		List<BokListVO> bokList = blService.getRestResult(bokSearchDTO);
		
	
		
		log.debug("결과물"+bokList);
		
		
		model.addAttribute("BOKLIST", bokList);
		
		
		return "boklist";
		
		
		
	}
	
	
	
	@RequestMapping(value="/detail", method=RequestMethod.GET, produces= "application/json;charset=UTF-8")
	public String detail(@RequestParam("id") String servId, Model model) {
		
		BokDetailVO bokDetail = bdService.getRestResult(servId);
		model.addAttribute("detail", bokDetail);
		
		return "bokdetail";
		
		
	}

}
