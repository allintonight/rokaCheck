package com.busan.check.api;

import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.busan.check.dto.ResponseDto;
import com.busan.check.model.Security;
import com.busan.check.model.Security.Location;
import com.busan.check.model.User;
import com.busan.check.repository.SecurityRepository;
import com.busan.check.repository.UserRepository;
import com.busan.check.service.SecurityService;

@RestController
public class SecurityApiController {
		
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private SecurityRepository securityRepository;
		
		@Autowired
		private SecurityService securityService;
		
		@PostMapping("checkin/weapon/{username}")
		public ResponseDto<Integer> 무기고출입(@RequestBody User user){
			System.out.println("무기고출입API호출");						
			securityService.무기고출입(user);
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);			
		}
		
		@PostMapping("/auth/checkin/bullet/{username}")
		public ResponseDto<Integer> 탄약고출입(@RequestBody User user){
			System.out.println("탄약고출입API호출");	
			securityService.탄약고출입(user);			
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);			
		}
		
		@PostMapping("checkin/security/{username}")
		public ResponseDto<Integer> 대외비출입(@RequestBody User user){
			System.out.println("대외비출입API호출");
			securityService.대외비출입(user);		
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);			
		}
		@PutMapping("checkout/weapon/{username}")
		public ResponseDto<Integer> 무기고퇴장(@RequestBody User user){
			securityService.무기고퇴장(user);				
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);			
		}
		@PutMapping("checkout/bullet/{username}")
		public ResponseDto<Integer> 탄약고퇴장(@RequestBody User user){
			securityService.탄약고퇴장(user);				
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);			
		}
		@PutMapping("checkout/security/{username}")
		public ResponseDto<Integer> 대외비퇴장(@RequestBody User user){
			securityService.대외비퇴장(user);				
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);			
		}
		
}
