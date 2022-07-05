package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RBoardDao;
import com.javaex.vo.RBoardVo;

@Service
public class RBoardService {
	
	//필드
	@Autowired
	RBoardDao rboardDao;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//리스트 불러오기 + 검색
	public List<Map<String, Object>> getList(String keyword) {
		
		System.out.println("RBoardService > getList");
		
		List<Map<String, Object>> boardList = rboardDao.getList(keyword);
		
		//System.out.println(boardList);
		
		return boardList;
		
	}
	
	//게시판 내용 읽기 + 조회수
	public Map<String, Object> read(int no) {
		
		System.out.println("RBoardService > read");
		
		//조회수 올리기
		rboardDao.boardHit(no);
		
		//게시판 내용 읽기
		Map<String, Object> bMap = rboardDao.read(no);
		
		return bMap;
		
	}
	
	//게시판 글쓰기
	public int write(RBoardVo rboardVo) {
		
		System.out.println("RBoardService > write");
		
		int count = rboardDao.write(rboardVo);

		return count;
	}
	
	//게시판 수정
	public int modify(RBoardVo rboardVo) {
		
		System.out.println("RBoardService > modify");
		
		int count = rboardDao.modify(rboardVo);
		
		return count;
		
	}
	
	//게시판 삭제
	public int delete(int no) {
		
		System.out.println("RBoardService > delete");
		
		int count = rboardDao.delete(no);
		
		return count;
		
	}
	
	//게시판 댓글쓰기
	public int coment(RBoardVo rboardVo) {
		
		System.out.println("RBoardService > coment");
		
		int count = rboardDao.coment(rboardVo);
		
		return count;
		
	}

}
