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

import com.javaex.service.RBoardService;
import com.javaex.vo.RBoardVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/rboard")
public class RBoardController {
	
	//필드
	@Autowired
	RBoardService rboardService; //new는 spring이 해줌
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//리스트 불러오기 + 검색
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model, String keyword) {
		
		System.out.println("RBoardController > list");
		
		List<Map<String, Object>> boardList = rboardService.getList(keyword);
		model.addAttribute("boardList", boardList);
		
		//System.out.println(boardList);
		
		return "rboard/list";
		
	}
	
	//게시판 내용 읽기 + 조회수
	@RequestMapping(value="/read/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(Model model, @PathVariable int no) {
		
		System.out.println("RBoardController > read");
				
		//내용 읽기
		Map<String, Object> bMap = rboardService.read(no);
		model.addAttribute("bMap", bMap);
		
		return "/rboard/read";
		
	}
	
	//게시판 글쓰기폼
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("RBoardController > writeForm");
		
		return "/rboard/writeForm";
		
	}
	
	//게시판 글쓰기
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute RBoardVo rboardVo, HttpSession session) {
		
		System.out.println("RBoardController > write");
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		rboardVo.setUserNo(authUser.getNo());
		
		System.out.println(rboardVo);
		//줄바꿈(구글링으로 찾아봄*재확인 필요)
		rboardVo.setContent(rboardVo.getContent().replace("\n", "<br>"));
		
		rboardService.write(rboardVo);
		
		return "redirect:/rboard/list";
		
	}
	
	//게시판 수정폼
	@RequestMapping(value="/modifyForm/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(Model model, @PathVariable int no) {
		
		System.out.println("RBoardController > modifyForm");
		
		Map<String, Object> bMap = rboardService.read(no);
		
		//줄바꿈(구글링으로 찾아봄*재확인 필요)
		String replace = ((String)bMap.get("CONTENT")).replace("<br>", "\n");
		bMap.put("CONTENT", replace);
		
		model.addAttribute("bMap", bMap);
		
		return "/rboard/modifyForm";
		
	}
	
	//게시판 수정
	@RequestMapping(value="/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute RBoardVo rboardVo) {
		
		System.out.println("RBoardController > modify");
		
		//줄바꿈(구글링으로 찾아봄*재확인 필요)
		rboardVo.setContent(rboardVo.getContent().replace("\n", "<br>"));
		
		rboardService.modify(rboardVo);
		
		return "redirect:/rboard/list";
		
	}
	
	//게시판 삭제
	@RequestMapping(value="/delete/{no}", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable int no) {
		
		System.out.println("RBoardController > delete");
		
		rboardService.delete(no);
		
		return "redirect:/rboard/list";
		
	}
	
	//게시판 댓글폼
	@RequestMapping(value="/comentForm/{no}", method = {RequestMethod.GET, RequestMethod.POST})
	public String comentForm(Model model, @PathVariable int no) {
		
		System.out.println("RBoardController > comentForm");
		
		model.addAttribute(no);
		
		return "/rboard/comentForm";
		
	}
	
	//게시판 댓글쓰기
	@RequestMapping(value="/coment", method = {RequestMethod.GET, RequestMethod.POST})
	public String coment(@ModelAttribute RBoardVo rboardVo) {
		
		System.out.println("RBoardController > coment");
		
		rboardService.coment(rboardVo);
		
		return "redirect:/rboard/list";
		
	}

}
