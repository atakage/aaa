package com.biz.iolist.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;
import com.biz.iolist.service.IolistService;


@RequestMapping(value="/iolist")
@Controller
public class IolistController {

	
	@Autowired
	IolistService ioService;
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String ioHome(Model model) {
		
		
		List<IolistVO> iolist = ioService.viewAllList();		// 아직 viewAllList() method를 생성하지 않은 상태에서 viewAllList()를 호출하여 할일을 먼저 정의한 것
																// TDD(Test Driven Developer)
		
		
		model.addAttribute("IOLIST", iolist);		// jsp view에서 사용할 변수 역할을 수행할 Attribute를 등록하는 절차이고
													// 이때 이름 "IOLIST"를 대문자로 사용하는 이유는 대소문자가 섞이면 문자 차이로인한 오류가 발생하거나
													// 값을 표시하지 못하는 일이 있는데 이를 방지하기 위함이다
		
		
		return "iolist/list";				// 슬래시??
	}
	
	
	
	
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)   // 새로 등록 버튼을 클랙했을 때 입력 폼을 보여주는 메소드
	public String list(Model model) {
		
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = sdf.format(date);
		
		IolistDTO ioDTO = IolistDTO.builder().io_seq(0).io_date(curDate).build();
		
		
		model.addAttribute("IO_DTO", ioDTO);
		return "iolist/input";
		
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)   // 입력폼에서 입력한 것을 보내기
																// POST에서 데이터를 수신할 때 DTO에 데이터를 받을 경우 DTO의 필드변수 중 String 값이 아닌 데이터가 있을 경우
															// 입력폼에서 해당값을 입력하지 않고 전송하면 400오류가 발생
	public String list(IolistDTO ioDTO, Model model) {
		
		
			int ret = ioService.insert(ioDTO);
		
	
		
		return "redirect:/iolist/list";			// insert, update, delete POST를 수행한 후 List보여서 변경된 사항을 보여줌
		
	}
	
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public String view(String id, Model model) {
		
		
		long io_seq = Long.valueOf(id);
		IolistDTO ioDTO = ioService.findBySEQ(io_seq);
		
		return "iolist/view";
		
	}
	
	
	
}
