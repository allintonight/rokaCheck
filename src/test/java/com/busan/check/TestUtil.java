package com.busan.check;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.busan.check.model.User;
import com.busan.check.model.Vacation;
import com.busan.check.model.VacationStatus;

public class TestUtil {
	
	public static User createValidUser() {
		User user = new User();
		user.setUsername("14-71017860");
		user.setName("홍길동");
		user.setPassword("P4sswrod");
		user.setUnit("1div 3r 1bn 2co");
		user.setPhone("010-9876-5432");
		user.setParentsPhone("010-1234-5678");
		user.setRanks("이등병");
		user.setPosition("1번소총수");
		user.setAddress("부산");
		return user;
	}
	
	public static User createValidUser(String username) {
		User user = createValidUser();
		user.setUsername(username);
		return user;
	}
	
	public static User createValidAdmin() {
		User user = createValidUser();
		user.setIsAdmin(1);
		return user;
	}
	
	public static Vacation createValidVacation() {
		Vacation vacation = new Vacation();
		vacation.setCheckin(LocalDate.now());
		vacation.setCheckout(LocalDate.now().plus(1, ChronoUnit.DAYS));
		return vacation;
	}
	
	public static Vacation createUsingVacation() {
		Vacation vacation = createValidVacation();
		vacation.setStatus(VacationStatus.USING);
		return vacation;
	}
}
