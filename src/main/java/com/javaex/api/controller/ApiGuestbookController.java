package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class ApiGuestbookController {
	
	//필드
	@Autowired
	private GuestService guestService;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//방명록 첫페이지(등록폼+리스트(ajax))
	@RequestMapping(value="/api/guestbook/addList", method={RequestMethod.GET, RequestMethod.POST})
	public String addList() {
		
		System.out.println("ApiGuestbookController > addList");
		
		return "apiGuestbook/addList";
		
	}
	
	//방명록 리스트 데이터만 보내기
	@ResponseBody
	@RequestMapping(value="/api/guestbook/list", method={RequestMethod.GET, RequestMethod.POST})
	public List<GuestVo> list() {
		
		System.out.println("ApiGuestbookController > list");
		
		List<GuestVo> guestList = guestService.addList();
		System.out.println(guestList);
		
		return guestList;
		
	}
	
	//방명록 저장
	@ResponseBody
	@RequestMapping(value="/api/guestbook/add", method={RequestMethod.GET, RequestMethod.POST})
	public GuestVo add(@ModelAttribute GuestVo guestVo) {
		
		System.out.println("ApiGuestbookController > add");
		
		GuestVo gvo = guestService.add(guestVo);
		
		return gvo;
		
	}
	
	//방명록 저장2
	@ResponseBody
	@RequestMapping(value="/api/guestbook/add2", method={RequestMethod.GET, RequestMethod.POST})
	public GuestVo add2(@RequestBody GuestVo guestVo) {
		
		System.out.println("ApiGuestbookController > add2");
		
		GuestVo gvo = guestService.add(guestVo);
		
		return gvo;
		
	}
	
	//방명록 삭제
	@ResponseBody
	@RequestMapping(value="/api/guestbook/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		
		System.out.println("ApiGuestbookController > delete");
		
		String state = guestService.guestDelete(guestVo);
		
		return state;
		
	}

}
