package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Restaurant {

	
	
	
	@Setter(onMethod_={ @Autowired})
	private Chef chef;
}
