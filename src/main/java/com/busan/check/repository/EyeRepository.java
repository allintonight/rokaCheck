package com.busan.check.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busan.check.model.EyeCheck;

//DAO
//자동으로 Bean등록이 된다 @Repository 생략가능
public interface EyeRepository extends JpaRepository<EyeCheck, Long> {
	
}
