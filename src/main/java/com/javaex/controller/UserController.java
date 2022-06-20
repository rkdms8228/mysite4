package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	//필드
	@Autowired
	UserService userService; //new는 spring이 해줌
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//회원가입폼
	@RequestMapping(value="/user/joinForm", method={RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		
		System.out.println("UserController > joinForm");
		
		return "user/joinForm";
		
	}
	
	//회원가입
	@RequestMapping(value="/user/join", method={RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		
		System.out.println("UserController > join");
		
		int count = userService.join(userVo);
		
		return "user/joinOk";
		
	}
		
	//로그인폼
	@RequestMapping(value="/user/loginForm", method={RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		
		System.out.println("UserController > loginForm");
		
		return "user/loginForm";
		
	}
	
	//로그인
	@RequestMapping(value="/user/login", method={RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		
		System.out.println("UserController > login");
		
		UserVo authUser = userService.login(userVo);
		
		/* 세션에 저장 */
		if(authUser != null) { //로그인 성공
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		}else { //로그인 실패
			System.out.println("로그인 실패");
			return "redirect:loginForm?result=fail";
		}

	}
	
	//로그아웃
	@RequestMapping(value="/user/logout", method={RequestMethod.GET, RequestMethod.POST})
	public String logout(@ModelAttribute UserVo userVo, HttpSession session) {
		
		System.out.println("UserController > logout");
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/main";
		
	}
		
	
	//수정폼
	@RequestMapping(value="/user/modifyForm", method={RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		
		System.out.println("UserController > modifyForm");
		
		return "user/modifyForm";
		
	}

}
