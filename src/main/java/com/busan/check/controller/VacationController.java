package com.busan.check.controller;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.busan.check.config.PrincipalDetail;
import com.busan.check.model.User;
import com.busan.check.model.Vacation;
import com.busan.check.model.vm.VacationVM;
import com.busan.check.service.VacationService;

@RestController
@RequestMapping("/api/1.0")
public class VacationController {

	@Autowired
	VacationService vacationService;
	
	@GetMapping("/vacations")
	public ResponseEntity<?> getAllTodayVacations(@AuthenticationPrincipal PrincipalDetail principal
											   , @RequestParam(defaultValue = "true") boolean mine
											   , @RequestParam(required = false) String unit
											   , Pageable pageable) {
		if (mine) {
			if (unit != null) {
				long count = vacationService.getCountTodayVacationsOfHierUnits(unit);
				return ResponseEntity.ok(Collections.singletonMap("count", count));
			}
			User user = principal.getUser();
			return ResponseEntity.ok(
					vacationService.getAllTodayVacationsOfUnit(user, pageable).map(VacationVM::new));
		} else if (unit != null) {
			return ResponseEntity.ok(
					vacationService.getAllTodayVacationsOfUnits(unit, pageable).map(VacationVM::new));
		}
		return ResponseEntity.ok(
				vacationService.getAllTodayVacations(pageable).map(VacationVM::new));
	}
	
	@PostMapping("/vacations/{username}")
	public VacationVM createVacation(@Valid @RequestBody Vacation vacation
								 , @PathVariable String username) {
		return new VacationVM(vacationService.save(vacation, username));
	}
	
	@PutMapping("/vacations/{username}")
	public VacationVM putVacationUpdate(@PathVariable String username) {
		Vacation updated = vacationService.update(username);
		return new VacationVM(updated);
	}
}
