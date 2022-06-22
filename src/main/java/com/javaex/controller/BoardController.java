package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	//필드
	@Autowired
	BoardService boardService; //new는 spring이 해줌
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//리스트 불러오기
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		System.out.println("BoardController > list");
		
		List<BoardVo> boardList = boardService.getList();
		model.addAttribute("boardList", boardList);
		
		return "board/list";
		
	}

}
