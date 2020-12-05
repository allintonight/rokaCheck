package com.busan.check.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import com.busan.check.config.PrincipalDetail;
import com.busan.check.model.User;
import com.busan.check.repository.UserRepository;
import com.busan.check.service.SecurityService;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;


@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SecurityService securityService;
	
	@GetMapping("/auth/login")
	public String login() {
		
		return "user/login";
	}
	@GetMapping("/auth/AdminjoinForm")
	public String adminJoinForm() {
		return "user/adminJoinForm";
	}
	
	@GetMapping("/userJoinForm")
	public String userJoinForm() {
		
		return "user/userJoinForm";
	}
	
	@GetMapping("/adminUpdateForm")
	public String adminUpdateForm(@AuthenticationPrincipal PrincipalDetail principal, Model model) {
		User user = userRepository.findByUsername(principal.getUsername()).orElseThrow(IllegalArgumentException::new);
		model.addAttribute("user", user);
		return "user/adminUpdateForm";
	}
	
	@GetMapping("/userUpdateForm")
	public String userUpdateForm() {
		
		return "user/userUpdateForm";
	}
	
	@GetMapping("/eye")
	public String eyeForm() {
		
		return "user/eye";
	}
	
	@GetMapping("/vacationRegister")
	public String vacationRegisterForm() {
		
		return "user/vacationRegister";
	}
	
	@GetMapping("/security")
	public String security(Model model) {
		model.addAttribute("weaponList", securityService.무기고());
		model.addAttribute("bulletList", securityService.탄약고());
		model.addAttribute("securityList", securityService.대외비());
		return "user/security";
	}
	@GetMapping("/status")
	public String status(Model model, Pageable pageable) {
		Page<User> userList = userRepository.findAllByIsAdmin(0, pageable);
		model.addAttribute("userList", userList);		
		return "user/status";
	}

	
	
}
