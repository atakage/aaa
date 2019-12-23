package com.biz.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;


							/* SessionAttribute로 설정된 변수(객체)는 response를 하기 전에 서버의 기억장소 어딘가에 임시로 보관함
 																web browser와 server간에 한번이라도 연결이 이루어졌으면 Session에 등록된 변수는 서버가 중단될 때까지
 																		그 값이 그대로 유지됨 web은 특성상 클라이언트의 req를 서버가 받아서 res를 수행하고 나면
 																			모든 정보가 사라지는 특성이 있음
 																					이런 특성과는 달리 Spring 기반의 web은 일부 데이터들을 메모리에 보관했다가
 																						 재사용하는 기법(essionAttribute)이 있음 */

@Slf4j
@RequestMapping(value="/memo")
@SessionAttributes("memoDTO")																				  
@Controller
public class MemoController {
	
	
	
	//@GetMapping
	
	//@PostMapping
	
	
	@Autowired
	MemoService memoService;
	
	
	
	@ModelAttribute("memoDTO")						/* sessionAttribute()에 설정하는  문자열(이름)은 클래스의 표준 객체생성 패턴에 의해 만들어진
	 																						만약 Attributes의 이름을 표준패턴이 아닌 임의의 이름으로 사용할 경우
	 													@ModelAttribute("객체이름")을 필수로 지정해 주어야 함   */
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
			
	/*		memoDTO = MemoDTO.builder().m_seq(9999) .m_auth("callor").m_date("2019-12-02").m_time("11시").m_text("댜해나무").build();   */
		
		
		model.addAttribute("memoDTO", memoDTO);
			return "insert";
			
		}
	
	
	
	
	/* insert POST가 memoDTO를 수신할 때 입력 form에서 사용자가 입력한 값들이 있으면 그 값들을 memoDTO의 필드변수에 setting하고 만약 없으면 메모리 어딘가에 보관 중인 SessionAttribute로 설정된 memoDTO변수에서 값을 가져와 필드변수를 채운 뒤 매개변수에 주입함, 따라서 홈페서 보이지 않아도 되는 값들은 별도의 코딩을 하지 않아도 자동으로 insert POST로 전송되는 효과를 냄 단 이 기능을 효율적으로 사용하려면 jsp코드에 Spring-form tag로 input를 코딩해야 함*/
	
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)									
	public String insert(@ModelAttribute MemoDTO memoDTO, String search, Model model, SessionStatus sessionStatus) {
		
		
		log.debug("시퀀스:" + memoDTO.getM_seq());
		log.debug("날짜:" + memoDTO.getM_date());
		log.debug("TEXT:" + memoDTO.getM_text());
		
		int ret = memoService.insert(memoDTO);
		
		sessionStatus.setComplete();		// 세션어트리뷰트를 사용할 때 insert, update가 완료되고 view로 보내기 전 반드시 setComplete()를 실행하여 
											// 세션에 담긴 값을 clear 햊 ㅜ어야 함
		
			return "redirect:/memo/list";
		
	}
	
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(@ModelAttribute MemoDTO memoDTO, Model model, @RequestParam("id") String str_seq) {
		
		
		long m_seq = 0;
		
	try {
		
		m_seq = Long.valueOf(str_seq);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		
	memoDTO = memoService.getMemo(m_seq);
		model.addAttribute("memoDTO", memoDTO);
		
		
		
		return "view";
		
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String id, @ModelAttribute MemoDTO memoDTO, Model model) {
		
		
		long m_seq = 0;
	
		try {
			m_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		memoDTO = memoService.getMemo(m_seq);
		
		model.addAttribute("memoDTO", memoDTO);
		
		
		return "insert";
		
		
		
	}
	
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute MemoDTO memoDTO, Model model) {
		
		

			int ret = memoService.update(memoDTO);
			return "redirect:/memo/list";
		
		
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)			/* 브라우저에서 delete를 호출할 때 m_seq변수에 값을 포함하지 않고 req 보내면
	 																					서버에서는 400오류가 발생, 그 이유는 Spring web에서 넘겨져 온 데이터를 long형으로 형변환을 수행하여 값을 받으려고 시도 , 그 과정에서 값이 없으면 null을 long으로 변환하는 코드가 실행되어 서버내부에서 exception이 발생하고 400 오류를 web에게 알려주게됨
	 																					이것을 방지하기 위해 String으로 일단 받고 별도로 Long.valueOf()를 실행하는 코드가 안전		*/
																	/* 하지만 delete를 호출할 때 절대 m_seq이 없게는 호출되지 않는다는 가정하에 바로 long형 변수로 수신가능*/
	public String delete(@ModelAttribute MemoDTO memoDTO) {
		
		
		int ret = memoService.delete(memoDTO.getM_seq());
		return "redirect:/memo/list";
		
		
	}
	

}
