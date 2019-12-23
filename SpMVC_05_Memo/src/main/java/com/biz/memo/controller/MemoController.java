package com.biz.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/memo")
@SessionAttributes("memoDTO")							/* SessionAttribute로 설정된 변수(객체)는 response를 하기 전에 서버의 기억장소 어딘가에 임시로 보관함
 																web browser와 server간에 한번이라도 연결이 이루어졌으면 Session에 등록된 변수는 서버가 중단될 때까지
 																		그 값이 그대로 유지됨 web은 특성상 클라이언트의 req를 서버가 받아서 res를 수행하고 나면
 																			모든 정보가 사라지는 특성이 있음
 																					이런 특성과는 달리 Spring 기반의 web은 일부 데이터들을 메모리에 보관했다가
 																						 재사용하는 기법(essionAttribute)이 있음 
 																						  */
@Controller
public class MemoController {
	
	
	
	//@GetMapping
	
	//@PostMapping
	
	
	@Autowired
	MemoService memoService;
	
	
	
	@ModelAttribute("memoDTO")
	public MemoDTO makeMemoDTO() {
		
		MemoDTO memoDTO = new MemoDTO();						/* SessionAttribute를 사용하기 위해서는 반드시 ㅎ당 변수를 생서하는 method가 controller 어딘가에 있어야 하고
		 															해당 메서드에는 @ModelAttribute("변수명")가 있어야 함(5.x미만은 필수 5.x이상에서는 선택)*/
		
		return memoDTO;
		
	}
	
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(String search, Model model) {
		
		
		
		
		List<MemoDTO> memoList;
		
		if(search == null || search.isEmpty()) {
			memoList = memoService.getAllList();
			
		}else {
			
			memoList = memoService.getSearchList(search);
			
		}
			
		
		model.addAttribute("MEMO_LIST", memoList);
		
		
		return "home";
		
		
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)	
	public String insert(@ModelAttribute("memoDTO") MemoDTO memoDTO, Model model) {
			
		memoDTO = MemoDTO.builder().m_seq(9999) .m_auth("callor").m_date("2019-12-02").m_time("11시").m_text("댜해나무").build();
		
		
		model.addAttribute("memoDTO", memoDTO);
			return "insert";
			
		}
	
	
	
	
	/* insert POST가 memoDTO를 수신할 때 입력 form에서 사용자가 입력한 값들이 있으면 그 값들을 memoDTO의 필드변수에 setting하고 만약 없으면 메모리 어딘가에 보관 중인 SessionAttribute로 설정된 memoDTO변수에서 값을 가져와 필드변수를 채운 뒤 매개변수에 주입함, 따라서 홈페서 보이지 않아도 되는 값들은 별도의 코딩을 하지 않아도 자동으로 insert POST로 전송되는 효과를 냄 단 이 기능을 효율적으로 사용하려면 jsp코드에 Spring-form tag로 input를 코딩해야 함*/
	
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)									
	public String insert(@ModelAttribute MemoDTO memoDTO, String search, Model model) {
		
		
		log.debug("시퀀스:" + memoDTO.getM_seq());
		log.debug("날짜:" + memoDTO.getM_date());
		log.debug("TEXT:" + memoDTO.getM_text());
		
		int ret = memoService.insert(memoDTO);
		
			return "redirect:/memo/list";
		
	}
	

}
