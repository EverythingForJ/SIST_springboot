package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("currentDate", new java.util.Date());
		return "view"; // /WEB-INF/jsp/ + view + .jsp
	}

	@RequestMapping("/user")
	public String user(Model model) {
		model.addAttribute("username", "한지민");
		model.addAttribute("userage", 24);
		model.addAttribute("job", "Developer");
		return "user";
	}

	@RequestMapping("/fruits")
	public String fruits(Model model) {
		String[] array = { "Apple", "Mango", "Lemon", "Grape" };
		model.addAttribute("fruits", array);
		return "fruits";
	}
}
