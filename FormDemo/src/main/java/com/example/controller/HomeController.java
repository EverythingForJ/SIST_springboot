package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
//	@GetMapping("/")
//	@ResponseBody
//	public String home() {
//		return "Hello, Spring Boot World!!!";
//	}
	
	@GetMapping("/")
	public String main() {
		return "index";  //확장자가 없으면 1)타임리프 2)JSP 
		//   /WEB-INF/views/index.jsp
	}
	
	@GetMapping("/register3")
	public String register() {
		return "register3";    //   /WEB-INF/views/register.jsp
	}
	
	@PostMapping("/register")
	public String register(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		int userage = Integer.parseInt(request.getParameter("userage"));
		String gender = request.getParameter("gender");
		String hobby = "";
		String [] array = request.getParameterValues("hobby");
		for(int i = 0 ; i < array.length ; i++) hobby += array[i] + ",";
		hobby = hobby.substring(0, hobby.length() - 1);
		String city = request.getParameter("city");
		log.warn("이름 : " + username);
		log.warn("취미 : " + hobby);
		
		model.addAttribute("username", username);
		model.addAttribute("userage", userage);
		model.addAttribute("gender", gender);
		model.addAttribute("hobby", hobby);
		model.addAttribute("city", city);
		return "result";   //  /WEB-INF/views/result.jsp
	}
	
	@PostMapping("/register1")
	public String register(@RequestParam("username") String username,
									@RequestParam("userage") int userage, 
									@RequestParam("gender") String gender,
									@RequestParam("hobby") String [] array,
									@RequestParam("city") String city,
									Model model) {
		
		String hobby = "";
		for(int i = 0 ; i < array.length ; i++) hobby += array[i] + ",";
		hobby = hobby.substring(0, hobby.length() - 1);
		
		model.addAttribute("username", username);
		model.addAttribute("userage", userage);
		model.addAttribute("gender", gender);
		model.addAttribute("hobby", hobby);
		model.addAttribute("city", city);
		return "result";   //  /WEB-INF/views/result.jsp
	}
	
	@PostMapping("/register2")
	public String register(UserVO userVO, Model model) {
		model.addAttribute("user", userVO);
		//log.warn("취미 : " + userVO.getHobby()[0]);
		return "result1";   // /WEB-INF/views/result1.jsp
	}
	
	@GetMapping("/register3/{username}/{userage}/{gender}/{hobby}/{city}")
	public void register(@PathVariable String username, 
			                      @PathVariable int userage,
			                      @PathVariable String gender,
			                      @PathVariable String [] hobby,
			                      @PathVariable String city) {
		log.warn("username = " + username);
		log.warn("userage = " + userage);
		log.warn("gender = " + gender);
		log.warn("hobby = " + hobby[0] + ", " + hobby[1]);
		log.warn("city = " + city);
	}
}


















