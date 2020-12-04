package com.busan.check.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.busan.check.config.PrincipalDetail;
import com.busan.check.model.User;
import com.busan.check.model.Vacation;
import com.busan.check.repository.UserRepository;
import com.busan.check.service.VacationService;


@Controller
public class HttpController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VacationService vacationService;

	
	@GetMapping({"/", ""})
	public String login() {
		return "user/login";
	}

	
	@GetMapping("/main")
	public String main(@AuthenticationPrincipal PrincipalDetail principal, Pageable pageable, Model model) {
		User user = userRepository.findByUsername(principal.getUsername()).orElseThrow(IllegalArgumentException::new);
		Page<Vacation> page = vacationService.getAllTodayVacationsOfUnit(user.getUsername(), pageable);
		model.addAttribute(page);
		return "/main";
	}

	
	
}
