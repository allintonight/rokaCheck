package com.busan.check.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busan.check.model.Vacation;
import com.busan.check.model.vm.VacationVM;
import com.busan.check.service.VacationService;

@RestController
@RequestMapping("/api/1.0")
public class VacationController {

	@Autowired
	VacationService vacationService;
	
	@PostMapping("/vacations/{username}")
	public VacationVM createVacation(@Valid @RequestBody Vacation vacation
								 , @PathVariable String username) {
		return new VacationVM(vacationService.save(vacation, username));
	}
	
	@GetMapping("/vacations")
	public Page<VacationVM> getAllTodayVacations(Pageable pageable) {
		return vacationService.getAllTodayVacations(pageable).map(VacationVM::new);
	}
	
	@GetMapping("/vacations/{username}")
	public Page<VacationVM> getAllTodayVacationsOfUnit(@PathVariable String username
													 , Pageable pageable) {
		return vacationService.getAllTodayVacationsOfUnit(username, pageable).map(VacationVM::new);
	}
}
