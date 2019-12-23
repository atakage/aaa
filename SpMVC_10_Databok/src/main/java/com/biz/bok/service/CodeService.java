package com.biz.bok.service;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class CodeService {

	
	
	public Map<String, Map<String, String>> getSelectMaps() {
		
		Map<String,Map<String, String>> selectMaps = new TreeMap<String, Map<String,String>>();
		
	
		selectMaps.put("srchKeyCode", this.srchKeyCode());
		
		selectMaps.put("lifeArray", this.lifeArray());
		selectMaps.put("charTrgterArray", this.charTrgterArray());
		selectMaps.put("obstKiArray", this.obstKiArray());
		selectMaps.put("obstAbtArray", this.obstAbtArray());
		selectMaps.put("trgterIndvdlArray", this.trgterIndvdlArray());
		selectMaps.put("desireArray", this.desireArray());
		
		
		
		return selectMaps;
		
	}
	
	
	
	
	public Map<String, String> srchKeyCode() {		//검색 조건 설정
		
		Map<String, String> srchKeyCode = new TreeMap<String, String>();
		
		
		srchKeyCode.put("001", "제목");
		srchKeyCode.put("002", "내용");
		srchKeyCode.put("003", "제목+내용");
		
		return srchKeyCode;
	}
	
	
	
	
	public Map<String, String> lifeArray() {	// 생애주기  조건
		
		Map<String, String> lifeArray = new TreeMap<String, String>();
		
		
		lifeArray.put("", "해당없음");
		lifeArray.put("001", "영유아");
		lifeArray.put("002", "아동");
		lifeArray.put("003", "청소년");
		lifeArray.put("004", "청년");
		lifeArray.put("005", "중장년");
		lifeArray.put("006", "노년");
		
		return lifeArray;
	}
	
	
	
	
	public Map<String, String> charTrgterArray() {		//대상특성
		
		Map<String, String> charTrgterArray = new TreeMap<String, String>();
		
		charTrgterArray.put("", "해당없음");
		
		charTrgterArray.put("002", "여성");
		charTrgterArray.put("003", "임산부");
		charTrgterArray.put("004", "장애");
		charTrgterArray.put("005", "국가유공자 등 보훈대상자");
		charTrgterArray.put("006", "실업자");
		
		return charTrgterArray;
	}
	
	
	
	
	public Map<String, String> obstKiArray() {		//장애유형(* 대상특성에 장애 클릭시 )
		
		Map<String, String> obstKiArray = new TreeMap<String, String>();
		
		obstKiArray.put("", "해당없음");
		obstKiArray.put("10", "지체");
		obstKiArray.put("20", "시각");
		obstKiArray.put("30", "청각");
		obstKiArray.put("40", "언어");
		obstKiArray.put("50", "지적");
		obstKiArray.put("60", "뇌병변");
		obstKiArray.put("70", "자폐성");
		obstKiArray.put("80", "정신");
		obstKiArray.put("90", "신장");
		obstKiArray.put("A0", "심장");
		obstKiArray.put("B0", "호흡기");
		obstKiArray.put("C0", "간");
		obstKiArray.put("D0", "안면");
		obstKiArray.put("E0", "장루");
		obstKiArray.put("F0", "간질");
		

		return obstKiArray;
	}
	
	
	
	
	
	

	public Map<String, String> obstAbtArray() {		//장애정도
		
		Map<String, String> obstAbtArray = new TreeMap<String, String>();
		
		
		obstAbtArray.put("", "해당 없음");
		obstAbtArray.put("10", "심한 장애");
		obstAbtArray.put("20", "심하지 않은 장애");
		
		
		return obstAbtArray;
	}
	
	
	
	
	public Map<String, String> trgterIndvdlArray() {		//가구유형
		
		Map<String, String> trgterIndvdlArray = new TreeMap<String, String>();
		
		trgterIndvdlArray.put("", "해당없음");
		
		trgterIndvdlArray.put("002", "한부모");
		trgterIndvdlArray.put("003", "다문화");
		trgterIndvdlArray.put("004", "조손");
		trgterIndvdlArray.put("005", "새터민");
		trgterIndvdlArray.put("006", "소년소녀가장");
		trgterIndvdlArray.put("007", "독거노인");

		
		
		return trgterIndvdlArray;
	}
	
	
	
	
	
	public Map<String, String> desireArray() {		//욕구
		
		Map<String, String> desireArray = new TreeMap<String, String>();
		
		
		desireArray.put("", "해당없음");
		desireArray.put("0000000", "안전");
		desireArray.put("1000000", "건강");
		desireArray.put("2000000", "일상생활유지");
		desireArray.put("3000000", "가족관계");
		desireArray.put("4000000", "사회적 관계");
		desireArray.put("5000000", "경제");
		desireArray.put("6000000", "교육");
		desireArray.put("7000000", "고용");
		desireArray.put("8000000", "생활환경");
		desireArray.put("9000000", "법률 및 권익보장");
		desireArray.put("A000000", "기타");

		
		return desireArray;
	}
	
}
