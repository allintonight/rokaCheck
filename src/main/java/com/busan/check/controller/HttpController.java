package com.busan.check.controller;

import java.util.ArrayList;
import java.util.List;

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
		User user = principal.getUser();
		Page<Vacation> page = vacationService.getAllTodayVacationsOfUnit(user, pageable);
		String[] unitArray = user.getUnit().split(" ");
		List<Long> totalCounts = new ArrayList<>();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < unitArray.length; i++) {
			buffer.append(unitArray[i]);
			long count = vacationService.getCountTodayVacationsOfHierUnits(buffer.toString());
			totalCounts.add(count);		
			buffer.append(" ");
		}
		model.addAttribute("page", page);
		model.addAttribute("user", user);
		model.addAttribute("totalCounts", totalCounts);
		return "main";
	}
}
