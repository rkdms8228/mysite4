package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value="/guestbook")
public class GuestbookController {
	
	//필드
	@Autowired
	GuestService guestService; //new는 spring이 해줌
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//방명록 리스트
	@RequestMapping(value="/addList", method={RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		
		System.out.println("GuestbookController > addList");
		
		List<GuestVo> guestList = guestService.addList();
		model.addAttribute("guestList", guestList);
		
		return "guestbook/addList";
		
	}
	
	//방명록 추가
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestVo guestVo) {
		
		System.out.println("GuestbookController > add");
		
		int count = guestService.guestAdd(guestVo);
		
		return "redirect:/guestbook/addList";
		
	}
	
	//방명록 삭제폼
	@RequestMapping(value="/deleteForm/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@PathVariable int no) {
		
		System.out.println("GuestbookController > deleteForm");
		
		return "/guestbook/deleteForm";
		
	}
	
	//방명록 삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		
		System.out.println("GuestbookController > delete");
		
		int count = guestService.guestDelete(guestVo);
		
		return "redirect:/guestbook/addList";
		
	}

}
