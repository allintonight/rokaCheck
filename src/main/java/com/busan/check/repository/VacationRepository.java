package com.busan.check.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.busan.check.model.User;
import com.busan.check.model.Vacation;

public interface VacationRepository extends JpaRepository<Vacation, Long> {

	@Query("select v from Vacation v where v.checkout = CURRENT_DATE")
	Page<Vacation> findAllByCheckout(Pageable pageable);
	
	@Query("select v from Vacation v where v.user.unit = :unit and v.checkout = CURRENT_DATE")
	Page<Vacation> findAllByStatusAndUserUnit(String unit, Pageable pageable);

		@Query(value = "SELECT * FROM VACATION where username =?1", nativeQuery = true)
	   Vacation findbyusername(String username);
}
