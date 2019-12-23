package com.biz.product.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */


@Slf4j
@Controller
public class HomeController {
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		
		return "redirect:/plist";
	}
	
	
	@ResponseBody
	@RequestMapping(value="nation", method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String getNation(String str) {
		
		
		log.debug("Req 변수 str:" + str);
		
		
		
		int sum = 0;
		for(int i = 0; i < 100000L; i++) {
			sum += i;
		}
		String strNation = "Republic Of Korea";
		strNation = str + sum;
		
		
		return strNation;
		
		
	}
	
}
