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
@RequestMapping("/api/1.0/vacations")
public class VacationController {

	@Autowired
	VacationService vacationService;
	
	@PostMapping("/{username}")
	public VacationVM createVacation(@Valid @RequestBody Vacation vacation
								 , @PathVariable String username) {
		return new VacationVM(vacationService.save(vacation, username));
	}
	
	@GetMapping
	public Page<VacationVM> getAllUsingVacations(Pageable pageable) {
		return vacationService.getAllUsingVacations(pageable).map(VacationVM::new);
	}
	
	@GetMapping("/{username}")
	public void getAllUsingVacations() {
		
	}
}
