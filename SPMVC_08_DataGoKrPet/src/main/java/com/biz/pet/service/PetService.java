package com.biz.pet.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.pet.config.DataGoConfig;
import com.biz.pet.domain.GoPetVO;
import com.biz.pet.domain.petrest.RestVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PetService {

	
	
	
	private final String go_pet_url = "http://openapi.jeonju.go.kr/rest/dongmulhospitalservice";
	
	public String getQueryHeader() {
		
		String queryString = go_pet_url;
		
		
		queryString += "/getDongMulHospital";
		
		
		queryString += "?ServiceKey=" + DataGoConfig.DATA_GO_AUTH;
		
		
		queryString += "&pageNo=1";
		queryString += "&numOfRows=100";
		

		
		return queryString;
		
	}
	
	public List<GoPetVO> getRestVoList(String s_cat, String s_text)   {
		
		String queryString = this.getQueryHeader();
		
		
		
		try {
			
			if(s_cat.equalsIgnoreCase("ADDR")) {
				queryString += "&address=" + URLEncoder.encode(s_text, "UTF-8");
				
			}else {
				queryString += "&dongName=" + URLEncoder.encode(s_text, "UTF-8");
			}
			
			
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HttpHeaders header =  new HttpHeaders();
		
		//header.setAccept(java.util.Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));		// JSON으로 수신하기
		
		
		
		 header.setAccept(java.util.Collections.singletonList(MediaType.APPLICATION_XML)); 		// XML로 수신하기
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", header);
		
		
		
		RestTemplate restTemp = new RestTemplate();		// Spring 3.2에서 도입된 새로운 HttpConnection 추상화된 객체
		
		URI restURI = null;
		//ResponseEntity<String> restList = null;
		
		ResponseEntity<RestVO> result = null;
		try {
			
			restURI = new URI(queryString);
			result = restTemp.exchange(restURI, HttpMethod.GET, entity, RestVO.class);
			RestVO rVO = (RestVO)result.getBody();
			
			
			List<GoPetVO> goPetList = rVO.body.data.list;
			
			log.debug("REST RESULT: "+result.getBody().toString());
			
			
			
			return goPetList;
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return null;
		
		
	}
	
	
/*	public List<GoPetVO> getRestVoList(String s_text){
		
		String queryString = this.getQueryHeader();
		
		JsonElement jElement = JsonParser.parseString(queryString);
		
		JsonObject oBody = (JsonObject) jElement.getAsJsonObject().get("body");
		
		JsonObject oTotal = (JsonObject) oBody.getAsJsonObject().get("totalCount");
		
	
		
		if(Integer.valueOf(oTotal.toString()) < 1) {
			return null;
		}
		
		
		JsonObject oData = (JsonObject) oBody.getAsJsonObject().get("data");
		
		
		
		
		
		
		JsonArray oList = null;
		List<GoPetVO> petList = new ArrayList<GoPetVO>();
		Gson gson = new Gson();
		
		try {
		
			oList = (JsonArray)oData.getAsJsonObject().get("list");		// List를 추출하여 JsonArray로 변환하는 과정에서 exception이 발생하면
																		// 추출된 데이터가 1개뿐일 경우
			
			TypeToken<List<GoPetVO>> typeListToken  = new TypeToken<List<GoPetVO>>() {};
			
			petList = gson.fromJson(oList, typeListToken.getType());
			
			
			
			return petList; 		// 정상적으로 list를 모두 추출했을 경우 전체 데이터의 list를 return
			
		} catch (ClassCastException e) {
			
			// TODO: exception이 발생했을 때는 1개짜리 list를 만들어서 return
			
			log.debug("데이터가 1개 뿐");
			JsonObject petObj = (JsonObject) oData.getAsJsonObject().get("list");
			TypeToken<GoPetVO> typeToken = new TypeToken<GoPetVO>() {};
			
			
			
			petList = new ArrayList<GoPetVO>();
			petList.add(gson.fromJson(petObj, typeToken.getType()));
			return petList;
			
		}
		
		// JsonArray를 list로 변환
		
	}*/
	
	
	
}
