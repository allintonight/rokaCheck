package com.busan.check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
	
	
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
	public String adminUpdateForm() {
		
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
	
	
	
}
