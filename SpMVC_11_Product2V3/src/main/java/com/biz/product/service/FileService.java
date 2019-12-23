package com.biz.product.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.product.domain.ProFileDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class FileService {
	
	@Autowired
	String winFilePath;
	
	
	
	
	
	List<String> upFileNames = new ArrayList<String>();
	
	
	public List<ProFileDTO> filesUp(MultipartHttpServletRequest u_files) throws Exception{		// 여러개의 파일을 개별파일로 분리하여 fileUp() method에게 보내서 파일을 업로드하도록 하고
																		// fileUp()이 생성한 업로드 파일이름을 return받아서 List에 추가한 후 파일이름 List를 
																				//Controller로 return
		
		
		List<ProFileDTO> upFileList = new ArrayList<ProFileDTO>();
		
		try {			// 만약 개별 파일을 업로드하는 중 문제가 발생핳면 cotroller에게 null값을 return하여 파일 업로드에 문제가 발생헀음을 알림
			
			
			
			for(MultipartFile file : u_files.getFiles("u_files")) {
			
				
				String upFileName = this.fileUp(file);
				
				ProFileDTO pf = ProFileDTO.builder().file_origin_name(file.getOriginalFilename()).file_upload_name(upFileName).build();
				
				upFileList.add(pf);
				
				
				log.debug("파일정보" + pf.toString());
				upFileNames.add(upFileName);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("Exception" + e.getMessage());
			return null;
		}
		
		
		
		
		
		
		
		return upFileList;
		
	}
	
	
	
	
	public String fileUp(MultipartFile u_file) {	// 1개의 파일을 서버 폴더에 업로드하고 
		
		
		
		String originName = u_file.getOriginalFilename();	// 업로드된 파일정보에서 파일이름만 추출
		
		
		
		
		
			// tomcat server가 작동되고 있는 곳에 대한 정보
															// getRealPath("/")는 톰캣 서버가 우리 프로젝트를 서비스할 때 root로 설정하여 여러가지 정보를 저장하고 있는
														// 폴더 정보 
		
		String upLoadPath = winFilePath;
	
		
		if(u_file != null) {
			
			File dir = new File(upLoadPath);	//  /files/ 폴더에 대한 IO 정보를 추출
			
			if(!dir.exists()) {		// 현재 서버에 /files/라는 폴더가 없으면
				
				dir.mkdirs();
			}
			
			// original 파일이름을 사용하면 해킹사고를 일으킬 수 있기 때문에 파일이름을 UUI로 설정하여 DB table에 저장
			String strUUID = UUID.randomUUID().toString();
			strUUID += originName;
			
			
			//= upLoadPath + originName;
			// product/files/2019.jpg 라는 이름으로 파일명을 만들고 
			File uploadFile = new File(upLoadPath, strUUID);
			
			
			// web에서 upload된 파일(u_file)을  방금 설정한 파일(upLoadFile)에 전송
			// web >> server로파일이 복사
			
			try {
				
				
				u_file.transferTo(uploadFile);		// u_file을 uploadFile로 복사
				
				//파일이 정상적으로 update가 되면 originalName을 Controller로 return할 것이고
				return strUUID;
				
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};		
			
			
			//파일이 정상적으로 upload가 안 되면
			// null값을 Controller로 return하라
			return originName;
			
			
			
		}
		
		return null;
		
	}

	public void fileDelete(String p_file) {
		// TODO Auto-generated method stub
		
		
		File dFile = new File(winFilePath, p_file);
		
		log.debug("삭제할 파일:" + p_file);
		
		if(dFile.exists()) {
			boolean ok = dFile.delete();
			
			if(ok) {
				log.debug("파일 삭제 성공");
			}else {
				log.debug("파일 삭제 실패");
			}
		}else {
			log.debug("삭제할 파일이 없음");
		}
		
		
	}
	

}
