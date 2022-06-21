package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	//필드
	@Autowired
	SqlSession sqlSession;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//방명록 리스트
	public List<GuestVo> guestSelect() {
		
		System.out.println("GuestDao > addList");
		
		List<GuestVo> guestList = sqlSession.selectList("guest.select");
		
		return guestList;
		
	}
	
	//방명록 추가
	public int guestAdd(GuestVo guestVo) {
		
		System.out.println("GuestDao > guestAdd");
		
		int count = sqlSession.insert("guest.insert", guestVo);
		
		return count;
		
	}
	
	//방명록 삭제
	public int guestDelete(GuestVo guestVo) {
		
		System.out.println("GuestDao > guestDelete");
		
		int count = sqlSession.delete("guest.delete", guestVo);
		
		return count;
		
	}

}
