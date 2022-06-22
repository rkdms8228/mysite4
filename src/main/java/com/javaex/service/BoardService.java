package com.javaex.service;

import java.util.List;

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
	//리스트 불러오기
	public List<BoardVo> getList() {
		
		System.out.println("BoardService > getList");
		
		List<BoardVo> boardList = boardDao.getList();
		
		return boardList;
		
	}

}
