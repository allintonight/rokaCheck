package com.busan.check.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.busan.check.model.User;
import com.busan.check.repository.UserRepository;
import com.busan.check.repository.VacationRepository;

//스프링이 컴포넌트 스캔을 통해 BEAN에 등록해줌
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encode;

	@Transactional
	public User 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encode.encode(rawPassword);
		user.setPassword(encPassword);
		user.setIsAdmin(1);

		return userRepository.save(user);
	}

	@Transactional
	public void 병사회원가입(User user) {

		userRepository.save(user);
	}

	@Transactional
	public void 관리자수정(String username, User requestUser) {
		Optional<User> user = userRepository.findByUsername(requestUser.getUsername());
		user.ifPresent(selectUser -> {
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


		});

	}

	@Transactional
	public void 병사수정(String username,  User requestUser) {
		userRepository.findByUsername(username).orElseThrow(()->{return new IllegalArgumentException("사용자 아이디 정보조회 실패");});
		User selectUser = userRepository.findbyusername(username);
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
		if (requestUser.getPosition() != null) {
			selectUser.setPosition(requestUser.getPosition());
		}
		if (requestUser.getRanks() != null) {
			selectUser.setRanks(requestUser.getRanks());
		}
		if (requestUser.getUnit() != null) {
			selectUser.setUnit(requestUser.getUnit());
		}
		if (requestUser.getParentsPhone() != null) {
			selectUser.setUnit(requestUser.getParentsPhone());
		}
		
		}
	

	@Transactional
	public void 삭제(String username) {
		userRepository.findByUsername(username).orElseThrow(() -> {
			return new IllegalArgumentException("사용자 아이디 정보조회 실패");
		});
		userRepository.deleteByUsername(username);
	}

	public User 사용자정보(String username) {
		userRepository.findByUsername(username).orElseThrow(() -> {
			return new IllegalArgumentException("사용자 아이디 정보조회 실패");
		});
		return userRepository.findbyusername(username);
	}
	
	 public void 메세지발송(String username) {
         userRepository.findByUsername(username).orElseThrow(()->{return new IllegalArgumentException("사용자 아이디 정보조회 실패");});
        User user = userRepository.findbyusername(username);

          MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
          parameters.add("api_key", "TMC52IGHR4E1202");
          parameters.add("msg", "충성! "+user.getName()+" "+user.getRanks()+"  부대에 복귀완료했습니다.");
          parameters.add("callback", "01035978787");
          parameters.add("dstaddr", user.getParentsPhone());
          parameters.add("send_reserve", "0");

          String url = "http://221.139.14.136/APIV2/API/sms_send";
          ResponseEntity<String> res = new RestTemplate().postForEntity(url, parameters, String.class);
          System.out.println(res.getBody());
          System.out.println(res.getStatusCodeValue());
   }
}
