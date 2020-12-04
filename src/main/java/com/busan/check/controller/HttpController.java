package com.busan.check.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.busan.check.config.PrincipalDetail;
import com.busan.check.repository.UserRepository;
import com.busan.check.service.UserService;

@Controller
public class HttpController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/", ""})
	public String login() {
		return "user/login";
	}

	
	@GetMapping("/main")
	public String main(@AuthenticationPrincipal PrincipalDetail principal,  Model model) {
		System.out.println("군번 : " + principal.getUsername());
		model.addAttribute("user", userService.사용자정보(principal.getUsername()));
		return "/main";
	}

	
	
}
