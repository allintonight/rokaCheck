package com.busan.check.model.vm;

import java.time.LocalDate;

import com.busan.check.model.Vacation;
import com.busan.check.model.VacationStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VacationVM {

	private long no;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private VacationStatus status;
	private UserVM user;

	public VacationVM(Vacation vacation) {
		this.no = vacation.getNo();
		this.checkIn = vacation.getCheckin();
		this.checkOut = vacation.getCheckout();
		this.status = vacation.getStatus();
		this.user = new UserVM(vacation.getUser());
	}
}
