package com.busan.check.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.busan.check.model.Security;

//DAO
//자동으로 Bean등록이 된다 @Repository 생략가능
public interface SecurityRepository extends JpaRepository<Security, Long> {

	Security findByusername(String username);

	@Query(value = "select username from security where location = 'weapon' order by id desc limit 1", nativeQuery = true)
	Security weapon(String username);
	
	@Query(value = "select username from security where location = 'bullet' order by id desc limit 1", nativeQuery = true)
	Security bullet(String username);
	
	@Query(value = "select username from security where location = 'security' order by id desc limit 1", nativeQuery = true)
	Security security(String username);
	
	@Query(value = "select * from security where location = 'weapon' and checkin like concat(curdate(),'%')", nativeQuery = true)
	List<Security> weaponList();
	
	@Query(value = "select * from security where location = 'bullet' and checkin like concat(curdate(),'%')", nativeQuery = true)
	List<Security> bulletList();
	
	@Query(value = "select * from security where location = 'security' and checkin like concat(curdate(),'%')", nativeQuery = true)
	List<Security> securityList();
}
