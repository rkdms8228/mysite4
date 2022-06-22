package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	//필드
	@Autowired
	BoardDao boardDao;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//리스트 불러오기 + 검색
	public List<Map<String, Object>> getList(String keyword) {
		
		System.out.println("BoardService > getList");
		
		List<Map<String, Object>> boardList = boardDao.getList(keyword);
		
		//System.out.println(boardList);
		
		return boardList;
		
	}
	
	//게시판 내용 읽기 + 조회수
	public Map<String, Object> read(int no) {
		
		System.out.println("BoardService > read");
		
		boardDao.boardHit(no);
		
		Map<String, Object> bMap = boardDao.read(no);
		
		return bMap;
		
	}
	
	//게시판 글쓰기
	public int write(BoardVo boardVo) {
		
		System.out.println("BoardService > write");
		
		int count = boardDao.write(boardVo);

		return count;
	}
	
	//게시판 수정
	public int modify(BoardVo boardVo) {
		
		System.out.println("BoardService > modify");
		
		int count = boardDao.modify(boardVo);
		
		return count;
		
	}
	
	//게시판 삭제
	public int delete(int no) {
		
		System.out.println("BoardService > delete");
		
		int count = boardDao.delete(no);
		
		return count;
		
	}

}
