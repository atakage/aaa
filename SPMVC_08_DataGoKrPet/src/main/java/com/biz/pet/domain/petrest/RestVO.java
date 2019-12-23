package com.biz.pet.domain.petrest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rfcOpenApi")				// java 1.7 이상에서만 작동, jaxb dependencies에 추가해주면 됨
public class RestVO {
	

	
	public RestBody body;
	
	
	
	
	

}
