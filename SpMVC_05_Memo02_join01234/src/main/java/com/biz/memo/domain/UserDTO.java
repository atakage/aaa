package com.biz.memo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@ScriptAssert(lang="javascript", script="(_this.u_password == _this.re_password)", reportOn = "re_password", message="비밀번호와 확인 비번이 다름")
public class UserDTO {
	
	
	
	/*
	 * 	@NotNull : null 이 아닌 경우에만 정상
	 * 	@Null : null일 경우에 정상
	 * 	@Max(x), @Min(x): 숫자의 최댓값 최솟값 제한
	 * 	@Size(min=x, max=x): 문자열일 경우
	 * 	@DecimalMax(x): x값 이하의 십진수
	 * 	@DecialMin(x): x값 이상의 십진수
	 * 	@Digits(x): x 자릿수 이하의 정수
	 * 	@Digits(integer=x, fraction=y) : x 자릿수 이하의 정수이면서 y자릿수 이하의 소수점 자릿수
	 * 
	 * 
	 * */
	
	
	@NotBlank(message="공백 안 됨")
	@NotNull
	@Email(message="이메일 형식으로만")			// emial 형식 검사
	@Size(min=5, max=100)
	private String u_id;
	private String u_password;
	private String re_password;
	private String u_name;
	
	
	
	@NotBlank(message="비어있으면 안 됨")		// 공백 검사
	private String u_nick;
	private String u_grade;
	
	@Pattern(regexp = "\\d{1,15}", message="1~15자리 정수만")
	private String u_tel;
	
	
	private String[] u_hobby;	// 사용자의 취미를 여러가지 중복 선탤할 수 있도록 하는 기능을 구현하기 위
	
	
}
