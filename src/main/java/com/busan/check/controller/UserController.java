package com.busan.check.controller;

import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busan.check.model.EyeCheck;
import com.busan.check.model.User;
import com.busan.check.model.Vacation;

import com.busan.check.repository.EyeRepository;
import com.busan.check.repository.UserRepository;
import com.busan.check.repository.VacationRepository;

@RestController
public class UserController {
	
	@Autowired // 의존성 주입
	private UserRepository userRepository;
	
	@Autowired
	private EyeRepository eyeRepository;
	
	@Autowired
	private VacationRepository vacationRepository;
	
	@PostMapping("/join")
	public String join(User user) {		
		
		 userRepository.save(user);
		 
		return "회원가입 완료";
	}
	
	@GetMapping("/user/{id}")
	public User detale(@PathVariable long id) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당유저는 없습니다. id : "+id);
			}
			
		});
		
		return user;
	}
	
	@Transactional
	@PutMapping("/userUpdate/{id}") 
	public String userUpdate(@PathVariable long id, @RequestBody User requestUser) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당유저는 없습니다. id : "+id);
			}
			
		});
		if(requestUser.getAdress()!=null) {user.setAdress(requestUser.getAdress());}
		if(requestUser.getEyeCheck()!=null) {user.setEyeCheck(requestUser.getEyeCheck());}
		if(requestUser.getIsAdmin()!=0) {user.setIsAdmin(requestUser.getIsAdmin());}
		if(requestUser.getParentsPhone()!=null) {user.setParentsPhone(requestUser.getParentsPhone());}
		if(requestUser.getPhone()!=null) {user.setPhone(requestUser.getPhone());}
		if(requestUser.getPosition()!=null) {user.setPosition(requestUser.getPosition());}
		if(requestUser.getRanks()!=null) {user.setRanks(requestUser.getRanks());}
		if(requestUser.getUnit()!=null) {user.setUnit(requestUser.getUnit());}
		
		return "수정 완료";
	}
	
	
	@PostMapping("/EyeUpdate/{id}")
	public String EyeUpdate(@PathVariable long id, @RequestBody EyeCheck eyeCheck) {
		eyeRepository.save(eyeCheck);
		return "홍채등록 완료";
	}
	
	@PostMapping("/VacationInsert/{id}")
	public String VacationInsert(@PathVariable long id, @RequestBody Vacation vacation) {
		vacationRepository.save(vacation);
		return "휴가등록 완료";
	}
	
	@Transactional
	@PutMapping("/VacationUpdate/{id}")
	public String VacationUpdate(@PathVariable long id, @RequestBody Vacation requestVacation) {
		Vacation vacation = vacationRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당유저는 없습니다. id : "+id);
			}
			
		});
		vacation.setCheckIn(requestVacation.getCheckIn());
		vacation.setCheckOut(requestVacation.getCheckOut());
		
		return "휴가수정 완료";
	}
	
	
	
}
