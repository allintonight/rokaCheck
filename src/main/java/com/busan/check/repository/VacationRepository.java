package com.busan.check.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.busan.check.model.User;
import com.busan.check.model.Vacation;
import com.busan.check.model.VacationStatus;

public interface VacationRepository extends JpaRepository<Vacation, Long> {

	@Query("select v from Vacation v where v.checkout = CURRENT_DATE")
	Page<Vacation> findAllByCheckout(Pageable pageable);
	
	@Query("select v from Vacation v where v.user.unit = :unit and v.checkout = CURRENT_DATE")
	Page<Vacation> findAllByStatusAndUserUnit(String unit, Pageable pageable);
	
	Vacation findByStatusAndUser(VacationStatus status, User user);

	@Query("select count(v) from Vacation v where v.user.unit like CONCAT(:unit, '%') and v.checkout = CURRENT_DATE")
	long countAllByStartsWithUserUnit(String unit);
	
	@Query("select count(v) from Vacation v where v.user.unit like CONCAT(:unit, '%') and v.checkout = CURRENT_DATE and v.status = 'COMPLETED'")
	long countAllByCompletedAndStartsWithUserUnit(String unit);

}
