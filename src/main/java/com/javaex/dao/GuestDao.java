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
	
	//방명록 추가(ajax)
	public int guestAdd(GuestVo guestVo) {
		
		System.out.println("GuestDao > guestAdd");
		
		//int count = sqlSession.insert("guest.insert", guestVo);
		int count = sqlSession.insert("guest.insertSelectKey", guestVo);
		
		return count;
		
	}
	
	//방명록 저장 후 등록한 데어터 가져오기(ajax)
	public GuestVo add(int no) {
		
		System.out.println("GuestDao > add");
		
		//int count = sqlSession.insert("guest.insert", guestVo);
		GuestVo guestVo = sqlSession.selectOne("guest.add", no);
		
		return guestVo;
		
	}
	
	//방명록 삭제
	public int guestDelete(GuestVo guestVo) {
		
		System.out.println("GuestDao > guestDelete");
		
		int count = sqlSession.delete("guest.delete", guestVo);
		
		return count;
		
	}

}
