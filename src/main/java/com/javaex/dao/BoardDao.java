package com.javaex.dao;

import java.util.List;
import java.util.Map;

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
	//리스트 불러오기 + 검색
	public List<Map<String, Object>> getList(String keyword) {
		
		System.out.println("BoardDao > getList");
		
		if(keyword == null) {
			keyword = "";
		}
		
		keyword = "%" + keyword + "%";
		List<Map<String, Object>> boardList = sqlSession.selectList("board.getList", keyword);
		
		//System.out.println(boardList);
		
		return boardList;
		
	}
	
	//게시판 내용 읽기
	public Map<String, Object> read(int no) {
		
		System.out.println("BoardDao > read");
		
		Map<String, Object> bMap = sqlSession.selectOne("board.read", no);
		
		return bMap;
		
	}
	
	//게시판 조회수
	public int boardHit(int no) {
		
		System.out.println("BoardDao > boardHit");
		
		int count = sqlSession.update("board.boardHit", no);
		
		return count;
		
	}
	
	//게시판 글쓰기
	public int write(BoardVo boardVo) {
		
		System.out.println("BoardDao > write");
		
		int count = sqlSession.insert("board.insert", boardVo);
		
		return count;
		
	}
	
	//게시판 수정
	public int modify(BoardVo boardVo) {
		
		System.out.println("BoardDao > modify");
		
		int count = sqlSession.update("board.modify", boardVo);
		
		return count;
		
	}

}
