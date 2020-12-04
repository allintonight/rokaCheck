package com.busan.check.api;

import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.busan.check.dto.ResponseDto;
import com.busan.check.model.EyeCheck;
import com.busan.check.model.User;
import com.busan.check.model.Vacation;
import com.busan.check.repository.EyeRepository;
import com.busan.check.repository.UserRepository;
import com.busan.check.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired // 의존성 주입
	private UserRepository userRepository;

	@Autowired
	private EyeRepository eyeRepository;
	


	@PostMapping("/auth/adminJoinProc")
	public ResponseDto<Integer> adminsave(@RequestBody User user) {
		System.out.println("회원가입API호출됨");
		user.setIsAdmin(1);
		System.out.println("군번"+user.getUsername());
		System.out.println("관리자"+user.getIsAdmin());
		System.out.println("폰번호"+user.getPhone());
		System.out.println("비밀번호"+user.getPassword());
		System.out.println("사단"+user.getUnit());
		System.out.println("이름"+user.getName());
		System.out.println("계급"+user.getRanks());
		
		userService.회원가입(user);
		

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	@PostMapping("/auth/userJoinProc")
	public ResponseDto<Integer> usersave(@RequestBody User user) {
		System.out.println("병사등록API호출됨");
		System.out.println("주소"+user.getAddress());
		System.out.println("군번"+user.getUsername());
		System.out.println("관리자"+user.getIsAdmin());
		System.out.println("폰번호"+user.getPhone());
		System.out.println("비밀번호"+user.getPassword());
		System.out.println("사단"+user.getUnit());
		System.out.println("이름"+user.getName());
		System.out.println("계급"+user.getRanks());
		
		userService.회원가입(user);
		

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	@DeleteMapping("/user/{username}")
	public  ResponseDto<Integer>  detale(@PathVariable String username) {
		System.out.println("회원삭제API호출");
		User user = userRepository.findByUsername(username).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당유저는 없습니다. 군번 : " + username);
			}
		});
		
		userService.삭제(username);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	@Transactional
	@PutMapping("/admin/{username}")
	public ResponseDto<Integer> adminUpdate(@PathVariable String username, @RequestBody User requestUser) {
		System.out.println("관리자수정API호출");
		User user = userRepository.findByUsername(username).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당유저는 없습니다. 군번 : " + username);
			}

		});
		

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	@Transactional
	@PutMapping("/user/{username}")
	public ResponseDto<Integer> userUpdate(@PathVariable String username, @RequestBody User requestUser) {
		System.out.println("병사수정API호출");
		User user = userRepository.findByUsername(username).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당유저는 없습니다. 군번 : " + username);
			}

		});
		

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	@PostMapping("/vacation/{username}")
	public ResponseDto<Integer> vacationsave(@RequestBody Vacation vacation) {
		System.out.println("휴가등록API호출됨");

		
		userService.휴가등록(vacation);
		

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	@PostMapping("/eye/{username}")
	public ResponseDto<Integer> EyeUpdate(@PathVariable String username, @RequestBody EyeCheck eyeCheck) {
		eyeRepository.save(eyeCheck);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
