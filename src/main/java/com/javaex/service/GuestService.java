package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {
	
	//필드
	@Autowired
	private GuestDao guestDao;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//방명록 리스트
	public List<GuestVo> addList() {
		
		System.out.println("GuestService > addList");
		
		List<GuestVo> guestList = guestDao.guestSelect();
		
		return guestList;
		
	}
	
	//방명록 추가
	public int guestAdd(GuestVo guestVo) {
		
		System.out.println("GuestService > guestAdd");
		
		int count = guestDao.guestAdd(guestVo);
		
		return count;
		
	}
	
	//방명록 추가(ajax)
	public GuestVo add(GuestVo guestVo) {
		
		System.out.println("GuestService > add");
		//저장
		int count = guestDao.guestAdd(guestVo);
		
		int no = guestVo.getNo();
		
		//방금 저장한 1개의 데이터를 가져오기
		GuestVo gvo = guestDao.add(no);
		
		return gvo;
		
	}
	
	//방명록 삭제
	public int guestDelete(GuestVo guestVo) {
		
		System.out.println("GuestService > guestDelete");
		
		int count = guestDao.guestDelete(guestVo);
		
		return count;
		
	}

}
