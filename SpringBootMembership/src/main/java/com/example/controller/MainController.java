package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

@Controller
public class MainController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";     // /templates/index.html
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";   //  /templates/register.html
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(MemberVO member) {
		this.memberService.insertMember(member);
		return "redirect:/";
	}
}
