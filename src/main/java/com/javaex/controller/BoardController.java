package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	//필드
	@Autowired
	UserService userService; //new는 spring이 해줌
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//리스트
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list() {
		
		System.out.println("BoardController > list");
		
		return "board/list";
		
	}

}
