package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	//필드
	@Autowired
	SqlSession sqlSession;

	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//갤러리 전체 가져오기
	public List<GalleryVo> imageList() {
		
		System.out.println("GalleryDao > imageList");
		
		List<GalleryVo> galleryList = sqlSession.selectList("gallery.imageList");
		
		return galleryList;
		
	}
	
	//1개의 이미지 정보 가져오기
	public GalleryVo getImage(int no) {
		
		System.out.println("GalleryDao > getImage");
		
		GalleryVo galleryVo = sqlSession.selectOne("gallery.getImage", no);
		
		return galleryVo;
		
	}
	
	//파일 정보 저장
	public int fileUpload(GalleryVo galleryVo) {
		
		System.out.println("GalleryDao > fileUpload");
		
		int count = sqlSession.insert("gallery.fileUpload", galleryVo);
		
		return count;
		
	}

}
