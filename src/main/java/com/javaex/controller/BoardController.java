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
import com.javaex.vo.UserVo;

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
				
		//내용 읽기
		Map<String, Object> bMap = boardService.read(no);
		model.addAttribute("bMap", bMap);
		
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
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		boardVo.setUserNo(authUser.getNo());
		
		//줄바꿈(구글링으로 찾아봄*재확인 필요)
		boardVo.setContent(boardVo.getContent().replace("\n", "<br>"));
		
		int count = boardService.write(boardVo);
		
		return "redirect:/board/list";
		
	}
	
	//게시판 수정폼
	@RequestMapping(value="/modifyForm/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(Model model, @PathVariable int no) {
		
		System.out.println("BoardController > modifyForm");
		
		Map<String, Object> bMap = boardService.read(no);
		
		//줄바꿈(구글링으로 찾아봄*재확인 필요)
		String replace = ((String)bMap.get("CONTENT")).replace("<br>", "\n");
		bMap.put("CONTENT", replace);
		
		model.addAttribute("bMap", bMap);
		
		return "/board/modifyForm";
		
	}
	
	//게시판 수정
	@RequestMapping(value="/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo) {
		
		System.out.println("BoardController > modify");
		
		//줄바꿈(구글링으로 찾아봄*재확인 필요)
		boardVo.setContent(boardVo.getContent().replace("\n", "<br>"));
		
		int count = boardService.modify(boardVo);
		
		return "redirect:/board/list";
		
	}
	
	//게시판 삭제
	@RequestMapping(value="/delete/{no}", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable int no) {
		
		System.out.println("BoardController > delete");
		
		int count = boardService.delete(no);
		
		return "redirect:/board/list";
		
	}

}
