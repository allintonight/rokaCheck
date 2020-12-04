package com.busan.check.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.busan.check.config.PrincipalDetail;

@Controller
public class HttpController {
	
	@GetMapping({"/", ""})
	public String login() {
		return "user/login";
	}

	
	@GetMapping("/main")
	public String main(@AuthenticationPrincipal PrincipalDetail principal) {
		System.out.println("군번 : " + principal.getUsername());
		return "/main";
	}

	
	
}
