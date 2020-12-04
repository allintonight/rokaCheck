package com.busan.check.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.busan.check.model.Vacation;
import com.busan.check.model.VacationStatus;

//DAO
//자동으로 Bean등록이 된다 @Repository 생략가능
public interface VacationRepository extends JpaRepository<Vacation, Long> {

	Page<Vacation> findAllByStatus(VacationStatus status, Pageable pageable);

	Page<Vacation> findAllByStatusAndUserUnit(VacationStatus status, String unit, Pageable pageable);
	

}
