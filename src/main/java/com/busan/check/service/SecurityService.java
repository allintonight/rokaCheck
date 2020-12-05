package com.busan.check.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busan.check.model.Security;
import com.busan.check.model.User;
import com.busan.check.model.Security.Location;
import com.busan.check.repository.SecurityRepository;
import com.busan.check.repository.UserRepository;

@Service
public class SecurityService {
		
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityRepository securityRepository;
	
	@Transactional
	public void 무기고출입(User user) {
		userRepository.findByUsername(user.getUsername()).orElseThrow(()->{return new IllegalArgumentException("사용자 아이디 정보조회 실패");});
		Security security = new Security();
		security.setUsername(user.getUsername());
		security.setName(user.getRanks()+" "+user.getName());
		security.setLocation(Location.weapon);		
		securityRepository.save(security);		
	}
	@Transactional
	public void 탄약고출입(User user) {
		userRepository.findByUsername(user.getUsername()).orElseThrow(()->{return new IllegalArgumentException("사용자 아이디 정보조회 실패");});
		Security security = new Security();
		security.setUsername(user.getUsername());
		security.setName(user.getRanks()+" "+user.getName());
		security.setLocation(Location.bullet);		
		securityRepository.save(security);		
	}
	@Transactional
	public void 대외비출입(User user) {
		userRepository.findByUsername(user.getUsername()).orElseThrow(()->{return new IllegalArgumentException("사용자 아이디 정보조회 실패");});
		Security security = new Security();
		security.setUsername(user.getUsername());
		security.setName(user.getRanks()+" "+user.getName());
		security.setLocation(Location.security);		
		securityRepository.save(security);		
	}
	@Transactional
	public void 무기고퇴장(User user) {
		userRepository.findByUsername(user.getUsername()).orElseThrow(()->{return new IllegalArgumentException("사용자 아이디 정보조회 실패");});
		Security security = securityRepository.weapon(user.getUsername());
		securityRepository.save(security);
	}
	@Transactional
	public void 탄약고퇴장(User user) {
		userRepository.findByUsername(user.getUsername()).orElseThrow(()->{return new IllegalArgumentException("사용자 아이디 정보조회 실패");});
		Security security = securityRepository.bullet(user.getUsername());
		securityRepository.save(security);
	}
	@Transactional
	public void 대외비퇴장(User user) {
		userRepository.findByUsername(user.getUsername()).orElseThrow(()->{return new IllegalArgumentException("사용자 아이디 정보조회 실패");});
		Security security = securityRepository.security(user.getUsername());
		securityRepository.save(security);
	}
	
	public List<Security> 무기고(){
		return securityRepository.weaponList();
	}
	
	public List<Security> 탄약고(){
		return securityRepository.bulletList();
	}
	
	public List<Security> 대외비(){
		return securityRepository.securityList();
	}

	
}
