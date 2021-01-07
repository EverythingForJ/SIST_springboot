package com.example.oauth2.security;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OAuth2Controller {

	@GetMapping({ "", "/" })
	public String getAuthorizationMessage() {
		return "home"; // /templates/home.html
	}

	@GetMapping("/login")
	public String login() {
		return "login"; // /templates/login.html
	}

	@GetMapping({ "/loginSuccess", "/hello" })
	public String loginSuccess(Principal principal, Model model) {
		return "hello"; // /templates/hello.html
	}

	@GetMapping("/loginFailure")
	public String loginFailure() {
		return "loginFailure"; // /templates/loginFailure.html
	}

	@GetMapping("/logout")
	public void logout() { // /templates/logout.html
		log.info("called Logout page");
	}
}
