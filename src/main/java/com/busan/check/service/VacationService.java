package com.busan.check.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.busan.check.model.User;
import com.busan.check.model.Vacation;
import com.busan.check.model.VacationStatus;
import com.busan.check.repository.UserRepository;
import com.busan.check.repository.VacationRepository;

@Service
public class VacationService {
	
	private final VacationRepository vacationRepository;
	private final UserRepository userRepository;
	
	public VacationService(VacationRepository vacationRepository, UserRepository userRepository) {
		this.vacationRepository = vacationRepository;
		this.userRepository = userRepository;
	}

	public Vacation save(@Valid Vacation vacation, String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new IllegalArgumentException("해당유저는 없습니다. 군번 : "+ username));
		vacation.setUser(user);
		if (vacation.getStatus() == null) {
			vacation.setStatus(VacationStatus.HAVING);			
		}
		return vacationRepository.save(vacation);
	}

	public Page<Vacation> getAllUsingVacations(Pageable pageable) {
		return vacationRepository.findAllByStatus(VacationStatus.USING, pageable);
	}

	public Page<Vacation> getVacationsOfUnit(String username, Pageable pageable) {
		User user = userRepository.findAll().get(0);
		return vacationRepository.findAllByStatusAndUserUnit(VacationStatus.USING, user.getUnit(), pageable);
	}
	
	
}
