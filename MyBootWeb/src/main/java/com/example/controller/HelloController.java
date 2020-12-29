package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String index() {
		return "index"; // 확장자를 쓰면 static에서 찾고, 안쓰면 template에서 찾는다.
		/*
		 *  정적페이지 index.html인 경우에는 반드시 static폴더아래에 만들고, 확장자 .html까지 표시할 것
		 *  But, index.html이 템플릿일 경우에는 반드시 template 폴더 아래에 만들고, 확장자 .html을 표시하지 않는다.
		 */
	}
	
	@RequestMapping("/{num}")
	public String index(@PathVariable int num, Model model) {
		int result = 0;
		for (int i = 1; i <= num; i++)
			result += i;
		model.addAttribute("msg", "1부터 "+ num+"까지의 합은 " + result+"입니다.");
		return "index"; // templates/index.html
	}


// String[] names = { "한지민", "박지민", "김지민" };
//	int[] ages = { 24, 28, 38 };
//	String[] addresses = { "서울특별시", "부산광역시", "대전광역시" };
//
//	@RequestMapping("/{userid}")
//	public StudentVO index1(@PathVariable int userid) {
//		return new StudentVO(userid, names[userid], ages[userid], addresses[userid]);
//	}

//	@RequestMapping("/")
//	public String index() {
//		return "Hello Spring Boot World!";
//	}

//	@RequestMapping("/{num}")
//	public String index(@PathVariable int num) {
//		int result = 0;
//		for (int i = 1; i <= num; i++)
//			result += i;
//		return "total : " + result;
//	}
}
