package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RBoardVo;

@Repository
public class RBoardDao {
	
	//필드
	@Autowired
	SqlSession sqlSession;
		
	//생성자
	
	//메소드-gs
	
	
	//메소드-일반
	//리스트 불러오기 + 검색
	public List<Map<String, Object>> getList(String keyword) {
		
		System.out.println("RBoardDao > getList");
		
		if(keyword == null) {
			keyword = "";
		}
		
		keyword = "%" + keyword + "%";
		List<Map<String, Object>> boardList = sqlSession.selectList("rboard.getList", keyword);
		
		//System.out.println(boardList);
		
		return boardList;
		
	}
	
	//게시판 내용 읽기
	public Map<String, Object> read(int no) {
		
		System.out.println("RBoardDao > read");
		
		Map<String, Object> bMap = sqlSession.selectOne("rboard.read", no);
		
		return bMap;
		
	}
	
	//게시판 조회수
	public int boardHit(int no) {
		
		System.out.println("RBoardDao > boardHit");
		
		int count = sqlSession.update("rboard.boardHit", no);
		
		return count;
		
	}
	
	//게시판 글쓰기
	public int write(RBoardVo rboardVo) {
		
		System.out.println("RBoardDao > write");
		
		System.out.println(rboardVo);
		
		int count = sqlSession.insert("rboard.rboardInsert", rboardVo);
		
		return count;
		
	}
	
	//게시판 수정
	public int modify(RBoardVo rboardVo) {
		
		System.out.println("RBoardDao > modify");
		
		int count = sqlSession.update("rboard.modify", rboardVo);
		
		return count;
		
	}
	
	//게시판 삭제
	public int delete(int no) {
		
		System.out.println("RBoardDao > delete");
		
		int count = sqlSession.delete("rboard.delete", no);
		
		return count;
		
	}
	
	//게시판 댓글쓰기
	public int coment(RBoardVo rboardVo) {
		
		System.out.println("RBoardDao > coment");
		
		int count = sqlSession.update("rboard.coment", rboardVo);
		
		return count;
		
	}

}
