package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class ApiUserController {
	
	//필드
	@Autowired
	private UserService userService;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	@ResponseBody
	@RequestMapping(value="/api/user/join", method={RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		
		System.out.println("UserController > join");
		
		String idCheck = userService.idCheck(userVo.getId());
		
		return idCheck;
		
	}

}
