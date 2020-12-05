package com.busan.check;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.busan.check.model.User;
import com.busan.check.model.Vacation;
import com.busan.check.model.VacationStatus;
import com.busan.check.service.UserService;
import com.busan.check.service.VacationService;

@SpringBootApplication
public class CheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckApplication.class, args);
	}
	
	@Bean
	@Profile("dev")
	CommandLineRunner run(UserService userService, VacationService vacationService) {
		return (String... args) -> {
			IntStream.rangeClosed(1, 10).forEach(i -> {
			User user = new User();
			user.setUsername("20-" + i);
			user.setName("병사" + i);
			user.setPhone("010-1234-" + i);
			user.setParentsPhone("012-222-" + i);
			user.setUnit("1div");
			user.setRanks("일병");
			userService.병사회원가입(user);
			
			Vacation vacation = new Vacation();
			vacation.setCheckin(LocalDate.now().minus(1, ChronoUnit.DAYS));
			vacation.setCheckout(LocalDate.now());
			vacation.setStatus(VacationStatus.USING);
			vacationService.save(vacation, user.getUsername());
		});
			
		IntStream.rangeClosed(1, 10).forEach(i -> {
			User user = new User();
			user.setUsername("20-1" + i);
			user.setName("병사" + i);
			user.setPhone("010-5892-" + i);
			user.setParentsPhone("010-4553-2786");
			user.setUnit("1div 1r 1bn 1co");
			user.setRanks("상병");
			userService.병사회원가입(user);
			
			Vacation vacation = new Vacation();
			vacation.setCheckin(LocalDate.now().minus(1, ChronoUnit.DAYS));
			vacation.setCheckout(LocalDate.now());
			vacation.setStatus(VacationStatus.USING);
			vacationService.save(vacation, user.getUsername());
		});
			User user = new User();
			user.setUsername("14-7101");
			user.setPassword("1234");
			user.setName("홍길동");
			user.setUnit("1div");
			userService.회원가입(user);
			
			user.setUsername("11");
			user.setPassword("11");
			user.setName("홍돌깅");
			user.setUnit("1div 1r 1bn 1co");
			userService.회원가입(user);
		};
	}

}
