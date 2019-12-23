package com.biz.gdata.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.gdata.config.DataGoConfig;
import com.biz.gdata.domain.AreaBaseDTO;
import com.biz.gdata.domain.CityVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;


@Service
public class TourAppService {
	
	
	@Autowired
	TourGetService tdService;
	
	
	
	

	private String getHeaderQuery(String servName) throws UnsupportedEncodingException {

		String queryString = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/" + servName;

		queryString += "?ServiceKey=" + DataGoConfig.goDataAuth;
		queryString += "&MobileApp=" + URLEncoder.encode(DataGoConfig.MY_APP_NAME, "UTF-8");
		queryString += "&_type=json";
		queryString += "&MobileOS=ETC";

		queryString += String.format("&numOfRows=%d", 20);
		queryString += String.format("&pageNo=%d", 1);

		return queryString;

	}

	public String getAreaQuery() throws UnsupportedEncodingException {

		String queryString = this.getHeaderQuery("areaCode");

		return queryString;

	}
	
	
	
	
	
	
	
	
	public String getAreaQuery(String cityCode) throws UnsupportedEncodingException {

		String queryString = this.getHeaderQuery("areaCode");
		queryString += "&areaCode=" + cityCode;

		return queryString;

	}
	
	// Cotroller에서 호출
	//city 코드가 없이 실행되는 코드
	// 시도 리스트를 추출하도록
	public List<CityVO> getAreaData() throws JsonSyntaxException, IOException {
		
		
		return this.getAreaData(null);
		
		
		
	}
	
	// Cotroller에서 호출
	// 시도 리스트를 선택했을 때 호출
	//city 코드가 있으면
	// 시군구 리스트를 추출하도록
	public List<CityVO> getAreaData(String cityCode) throws JsonSyntaxException, IOException {

		// JSONParser jParser = new JSONParser();
		
		
		String resString = ""; 
				if(cityCode == null) {
					resString = tdService.getDataString(this.getAreaQuery());		// 이 클래스에서 만든 query 문자열을 tdService의 getDateString()에 보내서 데이터 조회를 하는 method
				} else {
					resString = tdService.getDataString(this.getAreaQuery(cityCode));
				}

		JsonElement jElement = JsonParser.parseString(resString);

		// JSONArray jArray = null;

		JsonObject oRes = (JsonObject) jElement.getAsJsonObject().get("response"); // response tag
		JsonObject oBody = (JsonObject) oRes.getAsJsonObject().get("body"); // respose.body
		JsonObject oItems = (JsonObject) oBody.getAsJsonObject().get("items"); // response.body.items.item
		JsonArray oItemList = (JsonArray) oItems.getAsJsonObject().get("item"); //

		TypeToken<List<CityVO>> cityToken = new TypeToken<List<CityVO>>() {
		}; // gson에 있는 class로 JsonArray 데이터를 List형 데이터로 변환하는 도구
			// JsonArray를 List형으로 변환하기 위한 변환 바구니를 생성
			// Gson을 이용하여 List형으로 변환

		Gson gson = new Gson(); // token 도구를 사용하여 List<Class>형으로 변환하는 method 호출

		List<CityVO> cityList = gson.fromJson(oItemList, cityToken.getType());

		return cityList;

	}

	public String getAreaBaseQuery(String cityCode, String sigun) throws UnsupportedEncodingException {

		String queryString = this.getHeaderQuery("areaBasedList");

		queryString += "&arrange=A";
		queryString += "&contentTypeId=15";
		queryString += String.format("&areaCode=%s", cityCode);
		// queryString += String.format("&sigunguCode=%s", cityCode);
		queryString += "&listYN=Y";
		
		
		if(sigun != null) {
			queryString += "&sigunguCode=" + sigun;
		}
		queryString += "&sigunguCode" + sigun;
		
		return queryString;

	}
	
	public String getAreaBaseQuery(String cityCode) throws UnsupportedEncodingException {
		
		return this.getAreaBaseQuery(cityCode, null);
		
	}
	
	
	
	public List<AreaBaseDTO> getAreaBaseListData(String cityCode, String sigun) throws JsonSyntaxException, IOException {

		
		
		String resString = tdService.getDataString(this.getAreaBaseQuery(cityCode, sigun));

		JsonElement jElement = JsonParser.parseString(resString);

	

		JsonObject oRes = (JsonObject) jElement.getAsJsonObject().get("response"); 
		JsonObject oBody = (JsonObject) oRes.getAsJsonObject().get("body"); 
		JsonObject oItems = (JsonObject) oBody.getAsJsonObject().get("items"); 
		JsonArray oItemList = (JsonArray) oItems.getAsJsonObject().get("item"); 

		TypeToken<List<AreaBaseDTO>> cityToken = new TypeToken<List<AreaBaseDTO>>() {
		}; 
		Gson gson = new Gson(); 

		List<AreaBaseDTO> baseList = gson.fromJson(oItemList, cityToken.getType());

		return baseList;

	}

}
