package com.example.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SecurityController {
	@GetMapping("/")
	public String index() {
		log.info("called Index page");
		return "index"; // /templates/index.html
	}

	@GetMapping("/member")
	public void forMember() {
		log.warn("called Member page");
	}

	@GetMapping("/manager")
	public void forManager() {
		log.warn("called Manager page");
	}

	@GetMapping("/admin")
	public void forAdmin() {
		log.warn("called Admin page");
	}

	@GetMapping("/login")
	public void login() { // /templates/login.html
	}

	@GetMapping("/accessDenied")
	public void accessDenied() { // /templates/accessDenied.html
		log.info("called accessDenied page");
	}

	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		log.info("called loginSuccess page");
	}

	@GetMapping("/logout")
	public void logout() { // /templates/logout.html
		log.info("called Logout page");
	}
}
