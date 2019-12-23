package com.biz.product.domain;

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
public class ProFileDTO {				// 여러개의 이미지 파일 업로드 했을 때 해당 파일에 대한 정보를 저장하여 dbms에 전달하기 위한 DTO클래스

	private long file_seq;
	private String file_p_code;
	private String file_origin_name;
	private String file_upload_name;
	
	
	
}
