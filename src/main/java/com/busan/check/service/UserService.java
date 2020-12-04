package com.busan.check.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.busan.check.model.User;
import com.busan.check.model.Vacation;
import com.busan.check.repository.UserRepository;
import com.busan.check.repository.VacationRepository;

//스프링이 컴포넌트 스캔을 통해 BEAN에 등록해줌
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VacationRepository vacationRepository;
	
	@Autowired
	private BCryptPasswordEncoder encode;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();	
		String encPassword = encode.encode(rawPassword);
		user.setPassword(encPassword);
		user.setIsAdmin(1);
	
		userRepository.save(user);
	}
	@Transactional
	public void 관리자수정(User requestUser) {
		Optional<User> user = userRepository.findByUsername(requestUser.getUsername());
        user.ifPresent(selectUser->{
        	if (requestUser.getAddress() != null) {
    			selectUser.setAddress(requestUser.getAddress());
    		}
    		if (requestUser.getPassword() != null) {
    			selectUser.setPassword(requestUser.getPassword());
    		}
    		if (requestUser.getEyeCheck() != null) {
    			selectUser.setEyeCheck(requestUser.getEyeCheck());
    		}
    		if (requestUser.getIsAdmin() != 0) {
    			selectUser.setIsAdmin(requestUser.getIsAdmin());
    		}
    		if (requestUser.getPhone() != null) {
    			selectUser.setPhone(requestUser.getPhone());
    		}
    		if (requestUser.getPosition() != null) {
    			selectUser.setPosition(requestUser.getPosition());
    		}
    		if (requestUser.getRanks() != null) {
    			selectUser.setRanks(requestUser.getRanks());
    		}
    		if (requestUser.getUnit() != null) {
    			selectUser.setUnit(requestUser.getUnit());
    		}
    		String rawPassword = requestUser.getPassword();	
    		String encPassword = encode.encode(rawPassword);
    		selectUser.setPassword(encPassword);
    		selectUser.setIsAdmin(1);
    		
    		userRepository.save(selectUser);
    	
        });	
		
	}
	
	@Transactional
	public void 병사수정(User requestUser) {
		Optional<User> user = userRepository.findByUsername(requestUser.getUsername());
        user.ifPresent(selectUser->{
        	if (requestUser.getAddress() != null) {
    			selectUser.setAddress(requestUser.getAddress());
    		}
    		if (requestUser.getEyeCheck() != null) {
    			selectUser.setEyeCheck(requestUser.getEyeCheck());
    		}
    		
    		if (requestUser.getIsAdmin() != 0) {
    			selectUser.setIsAdmin(requestUser.getIsAdmin());
    		}
    		if (requestUser.getPhone() != null) {
    			selectUser.setPhone(requestUser.getPhone());
    		}
    		
    		if (requestUser.getParentsPhone() != null) {
    			selectUser.setParentsPhone(requestUser.getParentsPhone());
    		}
    		
    		if (requestUser.getPosition() != null) {
    			selectUser.setPosition(requestUser.getPosition());
    		}
    		if (requestUser.getRanks() != null) {
    			selectUser.setRanks(requestUser.getRanks());
    		}
    		if (requestUser.getUnit() != null) {
    			selectUser.setUnit(requestUser.getUnit());
    		}

    		selectUser.setIsAdmin(0);
    		
    		userRepository.save(selectUser);
    	
        });
        
		
	}
	@Transactional
	public void 삭제(String username) {
		Optional<User> user = userRepository.findByUsername(username);
        user.ifPresent(selectUser->{   	    		
    		userRepository.deleteByUsername(selectUser.getUsername());
    	
        });
	}
	@Transactional
	public void 휴가등록(Vacation vacation) {
	
		vacationRepository.save(vacation);
	}
	

}
