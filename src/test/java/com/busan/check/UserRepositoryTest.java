package com.busan.check;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.busan.check.model.User;
import com.busan.check.repository.UserRepository;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UserRepositoryTest {

	@Autowired
	TestEntityManager testEntityManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	@DisplayName("존재하는 군번으로 DB 조회하면 User 객체 받음")
	void findById_whenUserExists_returnsUser() {
		testEntityManager.persist(TestUtil.createValidUser());
		
		Optional<User> inDB = userRepository.findById(1471017860L);
		assertThat(inDB).isNotNull();
	}
	
	@Test
	@DisplayName("존재하지 않는 군번으로 DB 조회하면 Null 받음")
	void findById_whenUserDoesNotExists_returnsNull() {
		Optional<User> inDB = userRepository.findById(1471017860L);
		assertThat(inDB).isNotNull();
	}
}
