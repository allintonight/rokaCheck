package com.busan.check.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.busan.check.model.Vacation;

//DAO
//자동으로 Bean등록이 된다 @Repository 생략가능
public interface VacationRepository extends JpaRepository<Vacation, Long> {
	

}
