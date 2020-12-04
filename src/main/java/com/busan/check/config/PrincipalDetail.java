package com.busan.check.config;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.busan.check.model.User;

//principal (접근 주체) = 세션처럼 사용 = Spring Security Context 에 보관됨
public class PrincipalDetail implements UserDetails{


	private static final long serialVersionUID = 4892593073946728362L;

	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 계정의 비밀번호를 리턴한다.
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	// 계정의 이름을 리턴한다.
	@Override
	public String getUsername() {
		return user.getUsername();
	}
	

	// 계정이 만료되지 않았는 지 리턴한다. (true: 만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있지 않았는 지 리턴한다. (true: 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료되지 않았는 지 리턴한다. (true: 만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화(사용가능)인 지 리턴한다. (true: 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	// 계정이 갖고있는 권한 목록을 리턴한다. (권한이 여러개 있을 수 있어서 루프를 돌아야 하는데 우리는 한개만)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<SimpleGrantedAuthority> collectors = new ArrayList<>();
		collectors.add(new SimpleGrantedAuthority("ROLE_"+user.getIsAdmin()));
				
		return collectors;
	}
	
}