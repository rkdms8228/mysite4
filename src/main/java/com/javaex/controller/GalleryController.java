package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	//필드
	@Autowired
	GalleryService galleryService;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//갤러리 리스트
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String imageList(Model model) {
		
		System.out.println("GalleryController > imageList");
		
		List<GalleryVo> galleryList = galleryService.imageList();
		model.addAttribute("galleryList", galleryList);
		System.out.println(galleryList);
		
		return "/gallery/list";
		
	}
	
	//1개의 이미지 정보 가져오기
	@ResponseBody
	@RequestMapping(value="/getImage", method= {RequestMethod.GET, RequestMethod.POST})
	public GalleryVo getImage(Model model, @RequestParam("no") int no) {
		
		System.out.println("GalleryController > getImage");
		
		GalleryVo galleryVo = galleryService.getImage(no);
		
		return galleryVo;
		
	}
	
	//이미지 저장
	@RequestMapping(value="/upload", method= {RequestMethod.GET, RequestMethod.POST})
	public String upload(@ModelAttribute GalleryVo galleryVo) {
		
		System.out.println("GalleryController > upload");
		
		System.out.println(galleryVo);
		
		galleryService.upload(galleryVo);
		
		return "redirect:/gallery/list";
	}
	
	//이미지 삭제
	@ResponseBody
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no) {
		
		System.out.println("GalleryController > delete");
		
		String galleryDel = galleryService.delete(no);
		
		return galleryDel;
		
	}

}
