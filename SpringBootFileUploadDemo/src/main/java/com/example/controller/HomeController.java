package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.FileUploadService;

@Controller
public class HomeController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@GetMapping("/")
	public String home() {
		return "index"; // /WEB-INF/views/index.jsp
	}

	@GetMapping("/form")
	public String form() {
		return "form"; // /WEB-INF/views/index.jsp
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("email") String email, @RequestParam("file1") MultipartFile file, Model model) {
		String uri = fileUploadService.restore(file);
		model.addAttribute("uri", uri);
		return "result"; // /WEB-INF/views/result.jsp
	}

}
