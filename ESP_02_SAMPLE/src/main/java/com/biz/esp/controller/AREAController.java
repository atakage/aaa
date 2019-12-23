package com.biz.esp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.esp.domain.AreaDTO;
import com.biz.esp.domain.PaginationDTO;
import com.biz.esp.service.AreaService;
import com.biz.esp.service.PaginationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/esp")
@Controller
public class AREAController {

	@Autowired
	PaginationService paginationService;

	@Autowired
	AreaService areaService;

//	지역별 정책 메인
	@RequestMapping(value = "/area", method = RequestMethod.GET)
	public String area() {

		return "/area/area";
	}
	
	
//	지역별 정책 세부 보기
	@RequestMapping(value = "/area/view", method = RequestMethod.GET)
	public String areaView(String pa_acode, Model model) {
		
		AreaDTO areaDTO = areaService.viewAreaContent(pa_acode);
		
		String disName = null;
		int disSideSlideSW = 0;
		
		if(pa_acode.contains("ASE")) {
			
			disName = "seoul";
			disSideSlideSW = 1;
			
		}else if(pa_acode.contains("AIC")) {
			
			disName = "incheon";
			disSideSlideSW = 1;
		}else if(pa_acode.contains("ABU")) {
			
			disName = "busan";
			disSideSlideSW = 1;
		}else if(pa_acode.contains("ADJ")) {
			
			disName = "daejeon";
			disSideSlideSW = 1;
		}else if(pa_acode.contains("AGJ")) {
			
			disName = "gwangju";
			disSideSlideSW = 1;
		}else if(pa_acode.contains("AUS")) {
			
			disName = "ulsan";
			disSideSlideSW = 1;
		}else if(pa_acode.contains("ADG")) {
			
			disName = "daegu";
			disSideSlideSW = 1;
		}else if(pa_acode.contains("AGG")) {
			
			disName = "gyeonggi";
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AGW")) {
			
			disName = "gangwon";
			disSideSlideSW = 2;
		}else if(pa_acode.contains("ACN")) {
			
			disName = "chungbuk";
			disSideSlideSW = 2;
		}else if(pa_acode.contains("ACS")) {
			
			disName = "chungnam";
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AJN")) {
			
			disName = "jeonbuk";
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AJS")) {
			
			disName = "jeonnam";
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AGN")) {
			
			disName = "gyeongbuk";
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AGS")) {
			
			disName = "gyeongnam";
			disSideSlideSW = 2;
		}else if(pa_acode.contains("AJJ")) {
			
			disName = "jeju";
			disSideSlideSW = 2;
		}
		
		
					// 특정지역일시 지역이름과 광역시, 도 여부에 따라 disSideSlideSW 숫자값
		
		
		
		model.addAttribute("AREADTO", areaDTO);
		model.addAttribute("sideColorBold", disName);
		model.addAttribute("disSideSlideSW", disSideSlideSW);

		return "/area/areaview";
	}

//	서울특별시의 정책
	@RequestMapping(value = "/area/seoul", method = RequestMethod.GET)
	public String areaToSeoul(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		int seoulListCnt = paginationService.getSeoulListCnt(); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getSeoulContent(paginationDTO.getStartIndex() + 1);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "seoul");

		return "/area/areaSeoul";
	}
	
	
//	인천광역시의 정책
	@RequestMapping(value = "/area/incheon", method = RequestMethod.GET)
	public String areaToIncheon(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "AIC";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "incheon");

		return "/area/areaSeoul";
	}	
	
	
	
	
	
	//	부산광역시의 정책
	@RequestMapping(value = "/area/busan", method = RequestMethod.GET)
	public String areaToBusan(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "ABU";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "busan");

		return "/area/areaSeoul";
	}	
	
	
	
//	대전광역시의 정책
	@RequestMapping(value = "/area/daejeon", method = RequestMethod.GET)
	public String areaToDaejeon(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "ADJ";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "daejeon");

		return "/area/areaSeoul";
	}	
	
	
	
//	광주광역시의 정책
	@RequestMapping(value = "/area/gwangju", method = RequestMethod.GET)
	public String areaToGwangju(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "AGJ";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "gwangju");

		return "/area/areaSeoul";
	}	
	
	
	
	
//	울산광역시의 정책
	@RequestMapping(value = "/area/ulsan", method = RequestMethod.GET)
	public String areaToUlsan(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "AUS";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "ulsan");

		return "/area/areaSeoul";
	}	
	
	
	
	
	
	
//	대구광역시의 정책
	@RequestMapping(value = "/area/daegu", method = RequestMethod.GET)
	public String areaToDaegu(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {

		
		String pa_acode = "ADG";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);

		model.addAttribute("disSideSlideSW", 1);
		model.addAttribute("sideColorBold", "daegu");

		return "/area/areaSeoul";
	}	
	
	
	
	


//	경기도의 정책
	@RequestMapping(value = "/area/gyeonggi", method = RequestMethod.GET)
	public String areaToGyeonggi(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AGG";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "gyeonggi");

		return "/area/areaGyeonggi";
	}
	
	
	
//	강원도의 정책
	@RequestMapping(value = "/area/gangwon", method = RequestMethod.GET)
	public String areaToGangwon(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AGW";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "gangwon");

		return "/area/areaGyeonggi";
	}
	
	
	
	
//	충청북도의 정책
	@RequestMapping(value = "/area/chungbuk", method = RequestMethod.GET)
	public String areaToChungbuk(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "ACN";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "chungbuk");

		return "/area/areaGyeonggi";
	}
	
	
	
//	충청남도의 정책
	@RequestMapping(value = "/area/chungnam", method = RequestMethod.GET)
	public String areaToChungnam(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "ACS";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "chungnam");

		return "/area/areaGyeonggi";
	}
	
	
//	전라북도의 정책
	@RequestMapping(value = "/area/jeonbuk", method = RequestMethod.GET)
	public String areaToJeonbuk(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AJN";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "jeonbuk");

		return "/area/areaGyeonggi";
	}
	
	
	
	
//	전라남도의 정책
	@RequestMapping(value = "/area/jeonnam", method = RequestMethod.GET)
	public String areaToJeonnam(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AJS";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "jeonnam");

		return "/area/areaGyeonggi";
	}
	
	
//	경상북도의 정책
	@RequestMapping(value = "/area/gyeongbuk", method = RequestMethod.GET)
	public String areaToGyeongbuk(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AGN";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "gyeongbuk");

		return "/area/areaGyeonggi";
	}
	
	
	
	
	
	
	
//	경상남도의 정책
	@RequestMapping(value = "/area/gyeongnam", method = RequestMethod.GET)
	public String areaToGyeongnam(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AGS";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "gyeongnam");

		return "/area/areaGyeonggi";
	}
	
	
	
	
	
//	제주도의 정책
	@RequestMapping(value = "/area/jeju", method = RequestMethod.GET)
	public String areaToJeju(Model model, @RequestParam(defaultValue = "1", required = false) int curPage) {
		
		
		
		
		String pa_acode = "AJJ";
		
		int seoulListCnt = paginationService.getAreaListCnt(pa_acode); // 서울의 총 게시글 수 구해오기

		PaginationDTO paginationDTO = paginationService.startWork(seoulListCnt, curPage);

		List<AreaDTO> areaList = areaService.getAreaContent(paginationDTO.getStartIndex() + 1, pa_acode);

		model.addAttribute("AREALIST", areaList);
		model.addAttribute("PAGINATIONDTO", paginationDTO);
		
		
		
		
		

		model.addAttribute("disSideSlideSW", 2);
		model.addAttribute("sideColorBold", "jeju");

		return "/area/areaGyeonggi";
	}

}
