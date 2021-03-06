package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;



@Controller
@RequestMapping("/sample/*")
@Slf4j
public class SampleController {
	
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get only get...");
		
	}
	
	public void basicGet2() {
		
		log.info("basic get onley get...");
	}

}
