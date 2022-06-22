package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	//필드
	@Autowired
	SqlSession sqlSession;
		
	//생성자
	
	//메소드-gs
	
	
	//메소드-일반
	//리스트 불러오기
	public List<BoardVo> getList() {
		
		System.out.println("BoardDao > getList");
		
		List<BoardVo> boardList = sqlSession.selectList("board.getList");
		
		return boardList;
		
	}

}
