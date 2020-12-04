package com.busan.check.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.busan.check.model.User;
import com.busan.check.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	//스프링이 로그인요청을 가로챌때 username과 password를 가로챔
	//username db에 있는지 확인
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		User principal = userRepository.findByUsername(username).orElseThrow(()->{
	    	 return new UsernameNotFoundException("해당사용자를 찾을수 없습니다. : " + username);
	     });
	     return new PrincipalDetail(principal);
	}

}
