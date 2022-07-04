package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {
	
	//필드
	@Autowired
	GalleryDao galleryDao;

	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//갤러리 전체 가져오기
	public List<GalleryVo> imageList() {
		
		System.out.println("GalleryService > imageList");
		
		List<GalleryVo> galleryList = galleryDao.imageList();
		
		return galleryList;
			
	}
	
	//1개의 이미지 정보 가져오기
	public GalleryVo getImage(int no) {
		
		System.out.println("GalleryService > getImage");
		
		GalleryVo galleryVo = galleryDao.getImage(no);
		
		return galleryVo;
		
	}
	
	//파일 하드디스크 저장, 파일 정보(DB 저장) 추출 저장
	public void upload(GalleryVo galleryVo) {
		
		System.out.println("GalleryService > upload");
		
		String saveDir = "C:\\javaStudy\\upload";
		
		//[1]파일 정보(DB 저장) 추출 저장
		
		//오리지널 파일명
		String orgName = galleryVo.getFile().getOriginalFilename();
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//저장 파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		//파일 경로(디렉토리 + 저장 파일명)
		String filePath = saveDir + "\\" + saveName;
		
		//파일사이즈
		long fileSize = galleryVo.getFile().getSize();
		
		//vo에 추가
		galleryVo.setOrgName(orgName);
		galleryVo.setSaveName(saveName);
		galleryVo.setFilePath(filePath);
		galleryVo.setFileSize(fileSize);
		
		System.out.println("갤러리"+galleryVo);
		
		//DB 저장
		galleryDao.fileUpload(galleryVo);
		
		//[2]파일 저장
		try {
			
			byte[] fileData = galleryVo.getFile().getBytes();
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
