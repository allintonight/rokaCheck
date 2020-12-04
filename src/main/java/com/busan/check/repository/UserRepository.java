package com.busan.check.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.busan.check.model.User;

//DAO
//자동으로 Bean등록이 된다 @Repository 생략가능
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	void deleteByUsername(String username);

		
	//@Query(value = "SELECT * FROM USER WHERE USERNAME =?1 AND PASSWORD=?2", nativeQuery = true)
	//User login(String Id, String password);
}
