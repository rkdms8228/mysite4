package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.FileVo;

@Service
public class FileService {
	
	//필드


	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//파일 하드디스크 저장, 파일 정보(DB 저장) 추출 저장
	public String save(MultipartFile file) {
		
		System.out.println("FileService > save");
		
		String saveDir = "C:\\javaStudy\\upload";
		
		//[1]파일 정보(DB 저장) 추출 저장
		
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println(exName);
		
		//저장 파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		//파일 경로(디렉토리 + 저장 파일명)
		String filePath = saveDir + "\\" + saveName;
		
		//파일 사이즈
		long fileSize = file.getSize();
		
		//vo로 묶기
		FileVo fileVo = new FileVo(orgName, saveName, filePath, fileSize);
		System.out.println(fileVo);
		//--> dao DB저장
		
		
		//[2]파일 저장
		try {
			
			byte[] fileData = file.getBytes();
			
			OutputStream os =  new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saveName;
		
	}
	

}
