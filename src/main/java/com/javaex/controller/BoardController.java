package com.javaex.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	//리스트 불러오기 + 검색
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, String keyword) {
		
		System.out.println("BoardController > list");
		
		List<Map<String, Object>> boardList = boardService.getList(keyword);
		model.addAttribute("boardList", boardList);
		
		//System.out.println(boardList);
		
		return "board/list";
		
	}
	
	//게시판 내용 읽기 + 조회수
	@RequestMapping(value="/read/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(Model model, @PathVariable int no) {
		
		System.out.println("BoardController > read");
		
		//내용 일기
		Map<String, Object> bMap = boardService.read(no);
		model.addAttribute("bMap", bMap);
		
		//조회수
		int count = boardService.boardHit(no);
		
		return "/board/read";
		
	}
	
	//게시판 글쓰기폼
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("BoardController > writeForm");
		
		return "/board/writeForm";
		
	}
	
	//게시판 글쓰기
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo, HttpSession session) {
		
		System.out.println("BoardController > write");
		
		BoardVo authUser = (BoardVo)session.getAttribute("authUser");
		boardVo.setUserNo(authUser.getNo());
		
		//줄바꿈
		String replace = boardVo.getContent().replace("\n", "<br>");
		boardVo.setContent(replace);
		
		int count = boardService.write(boardVo);
		
		return "redirect:/board/list";
		
	}

}
