package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.UserService;
import com.example.vo.UserVO;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register.html";
	}
	
	@PostMapping("/register")
	public String register(UserVO userVo) {
		this.userService.insertUser(userVo);
		return "redirect:/";
	}
	
	@GetMapping("/welcome")
	public String login() {
		return "welcome.html";
	}
	
}
