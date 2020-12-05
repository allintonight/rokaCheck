package com.busan.check;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.busan.check.error.ApiError;
import com.busan.check.model.User;
import com.busan.check.model.Vacation;
import com.busan.check.model.VacationStatus;
import com.busan.check.model.vm.VacationVM;
import com.busan.check.repository.UserRepository;
import com.busan.check.repository.VacationRepository;
import com.busan.check.service.VacationService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class VacationControllerTest {
	
	private static final String API_1_0_VACATIONS = "/api/1.0/vacations";

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VacationRepository vacationRepository;
	
	@Autowired
	VacationService vacationService;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@BeforeEach
	public void cleanup() {
		vacationRepository.deleteAll();
		userRepository.deleteAll();
	}
	
	@Test @DisplayName("휴가 등록시 status 200 받음")
	void postVacation_whenVacationIsValid_receiveOk() {
		User user = userRepository.save(TestUtil.createValidUser());
		authenticate();
		Vacation vacation = TestUtil.createValidVacation();
		ResponseEntity<Object> response = postVacation(vacation, user.getUsername(), Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	@Test @DisplayName("휴가 등록시 DB에 저장됨")
	void postVacation_whenVacationIsValid_vacationSavedToDB() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = TestUtil.createValidVacation();
		postVacation(vacation, user.getUsername(), Object.class);
		assertThat(vacationRepository.count()).isEqualTo(1);
	}
//	@Test @DisplayName("휴가 등록시 군번이 DB에 없을 경우 400 받음")
//	void postVacation_whenVacationUserIdIsNotInDB_receiveBadRequest() {
//		User user = userRepository.save(TestUtil.createValidUser());
//		Vacation vacation = TestUtil.createValidVacation();
//		ResponseEntity<Object> response = postVacation(vacation, user.getUsername(), Object.class);
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//	}
	@Test @DisplayName("휴가 등록시 checkIn이 Null일 경우 400 받음")
	void postVacation_whenVacationCheckInIsNull_receiveBadRequest() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = TestUtil.createValidVacation();
		vacation.setCheckin(null);
		ResponseEntity<Object> response = postVacation(vacation, user.getUsername(), Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	@Test @DisplayName("휴가 등록시 checkOut이 Null일 경우 400 받음")
	void postVacation_whenVacationCheckOutIsNull_receiveBadRequest() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = TestUtil.createValidVacation();
		vacation.setCheckout(null);
		ResponseEntity<Object> response = postVacation(vacation, user.getUsername(), Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	@Test @DisplayName("휴가 등록시 출발 일자가 복귀 일자보다  빠르지 않으면 400 받음")
	void postVacation_whenVacationCheckOutIsAfterCheckIn_receiveBadRequest() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = TestUtil.createValidVacation();
		vacation.setCheckout(LocalDate.of(1999, 1, 1));
		ResponseEntity<Object> response = postVacation(vacation, user.getUsername(), Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	@Test @DisplayName("휴가 등록시 출발 일자가 복귀 일자보다  빠르지 않으면 에러메시지 받음")
	void postVacation_whenVacationCheckOutIsAfterCheckIn_receive() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = TestUtil.createValidVacation();
		vacation.setCheckout(LocalDate.of(1999, 1, 1));
		ResponseEntity<ApiError> response = postVacation(vacation, user.getUsername(), ApiError.class);
		assertThat(response.getBody().getMessage()).isNotNull();
	}
	@Test @DisplayName("휴가 등록시 자동으로 휴가 보유 상태")
	void postVacation_whenVacationIsValid_vacationStatusIsHaving() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = TestUtil.createValidVacation();
		ResponseEntity<VacationVM> response = postVacation(vacation, user.getUsername(), VacationVM.class);
		assertThat(response.getBody().getStatus()).isEqualTo(VacationStatus.HAVING);
	}
	@Test @DisplayName("휴가 등록시 user 객채도 같이 저장")
	void postVacation_whenVacationIsValid_vacationSavedWithUserInOf() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = TestUtil.createValidVacation();
		ResponseEntity<VacationVM> response = postVacation(vacation, user.getUsername(), VacationVM.class);
		assertThat(response.getBody().getUser().getName()).isEqualTo("홍길동");
	}
	@Test @DisplayName("휴가 등록시 user 객채도 같이 저장")
	void postVacation_whenVacationIsValid_vacationCanBeAccessedFromUserEntity() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = TestUtil.createValidVacation();
		postVacation(vacation, user.getUsername(), VacationVM.class);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		User inDB = entityManager.find(User.class, user.getNo());
		assertThat(inDB.getVacations().size()).isEqualTo(1);
	}
	
	
	@Test @DisplayName("휴가자 조회시 아무도 없어도 200 받음")
	void getVacations_whenThereAreNoVacations_receiveOk() {
		ResponseEntity<Object> response = getVacations(new ParameterizedTypeReference<Object>() {});
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	@Test @DisplayName("휴가자 조회시 아무도 없어도 Page 객체 받음")
	void getVacations_whenThereAreNoVacations_receivePageWithZeroItems() {
		ResponseEntity<TestPage<Object>> response = getVacations(new ParameterizedTypeReference<TestPage<Object>>() {});
		assertThat(response.getBody().getTotalElements()).isEqualTo(0);
	}
	@Test @DisplayName("휴가자 조회시 1명 있을 경우 Page item 1개 받음")
	void getVacations_whenThereAreAVacation_receivePageWithVacation() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = TestUtil.createUsingVacation();
		vacationService.save(vacation, user.getUsername());
		ResponseEntity<TestPage<Object>> response = getVacations(new ParameterizedTypeReference<TestPage<Object>>() {});
		assertThat(response.getBody().getTotalElements()).isEqualTo(1);
	}
	@Test @DisplayName("휴가자 조회시 3명 있을 경우 Page item 3개 받음")
	void getVacations_whenThereAre3Vacations_receivePageWith3Vacation() {
		IntStream.rangeClosed(1, 3).mapToObj(i -> "14-7101786" + i)
			.map(TestUtil::createValidUser).forEach(userRepository::save);
		vacationService.save(TestUtil.createUsingVacation(), "14-71017861");
		vacationService.save(TestUtil.createUsingVacation(), "14-71017862");
		vacationService.save(TestUtil.createUsingVacation(), "14-71017863");
		
		ResponseEntity<TestPage<Object>> response = getVacations(new ParameterizedTypeReference<TestPage<Object>>() {});
		assertThat(response.getBody().getTotalElements()).isEqualTo(3);
	}
//	@Test @DisplayName("진행 중인 휴가만 조회")
//	void getVacations_whenThereAreVacations_receiveOnlyUsingVacation() {
//		User user = userRepository.save(TestUtil.createValidUser());
//		vacationService.save(TestUtil.createUsingVacation(), user.getUsername());
//		vacationService.save(TestUtil.createValidVacation(), user.getUsername());
//		
//		ResponseEntity<TestPage<Object>> response = getVacations(new ParameterizedTypeReference<TestPage<Object>>() {});
//		assertThat(response.getBody().getTotalElements()).isEqualTo(1);
//	}
	@Test @DisplayName("로그인 한 회원 소속의 병사 휴가자 조회시 status 200 받음")
	void getVacationsOfUnit_whenThereAreVacations_receiveOk() {
		User admin = userRepository.save(TestUtil.createValidAdmin());
		ResponseEntity<Object> response = getVacationsOfMyUnit(admin.getUsername(), new ParameterizedTypeReference<Object>() {});
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	@Test @DisplayName("존재하지 않는 회원의 군번으로 소속 병사 휴가자 조회시 status 400 받음")
	void getVacationsOfUnit_whenThereAreVacations_receiveNotFound() {
		ResponseEntity<Object> response = getVacationsOfMyUnit("unknown-user", new ParameterizedTypeReference<Object>() {});
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	@Test @DisplayName("로그인 한 회원 소속의 병사 휴가자 조회시 0명이어도 page 객체 받음")
	void getVacationsOfUnit_whenVacationsAreNotExist_receiveOk() {
		User admin = userRepository.save(TestUtil.createValidAdmin());
		ResponseEntity<TestPage<Object>> response = getVacationsOfMyUnit(admin.getUsername(), new ParameterizedTypeReference<TestPage<Object>>() {});
		assertThat(response.getBody().getTotalElements()).isEqualTo(0);
	}
	@Test @DisplayName("로그인 한 회원 소속의 병사 휴가자만 조회")
	void getVacationsOfUnit_whenThereAreVacations_receiveOnlyUsingVacationWhereSameUnitIsOf() {
		User admin = userRepository.save(TestUtil.createValidAdmin());
		IntStream.rangeClosed(1, 2).mapToObj(i -> "14-7101786" + i)
			.map(TestUtil::createValidUser).forEach(userRepository::save);
		vacationService.save(TestUtil.createUsingVacation(), "14-71017861");
		vacationService.save(TestUtil.createUsingVacation(), "14-71017862");
		
		User differentUser = TestUtil.createValidUser("14-71017863");
		differentUser.setUnit("15div 39r 1bn 3co");
		userRepository.save(differentUser);
		vacationService.save(TestUtil.createUsingVacation(), "14-71017863");
		
		ResponseEntity<TestPage<Object>> response = getVacationsOfMyUnit(admin.getUsername(), new ParameterizedTypeReference<TestPage<Object>>() {});
		assertThat(response.getBody().getTotalElements()).isEqualTo(2);
	}
	@Test @DisplayName("로그인 한 회원 소속의 오늘 복귀인 휴가자만 조회")
	void getVacationsOfUnit_whenThereAreVacations_receiveOnlyUsingVacationWhereSameUnitIsOfComeToday() {
		User admin = userRepository.save(TestUtil.createValidAdmin());
		userRepository.save(TestUtil.createValidUser());
		
		vacationService.save(TestUtil.createUsingVacation(), "14-71017860");
		Vacation vacation = TestUtil.createUsingVacation();
		vacation.setCheckout(LocalDate.now().plus(1, ChronoUnit.DAYS));
		vacationService.save(vacation, "14-71017860");
		
		ResponseEntity<TestPage<Object>> response = getVacationsOfMyUnit(admin.getUsername(), new ParameterizedTypeReference<TestPage<Object>>() {});
		assertThat(response.getBody().getTotalElements()).isEqualTo(1);
	}
	@Test @DisplayName("휴가 상태 COMPLETED로 변경시 status 200 받음")
	void putVacationsOfUser_whenVacationStatusIsUsing_receiveOk() {
		User user = userRepository.save(TestUtil.createValidUser());
		vacationService.save(TestUtil.createUsingVacation(), "14-71017860");
		ResponseEntity<Object> response = putVacationsOfUser(user.getUsername(), null, Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	@Test @DisplayName("휴가 상태 COMPLETED로 변경시 DB에 반영됨")
	void putVacationsOfUser_whenVacationStatusIsUsing_updated() {
		User user = userRepository.save(TestUtil.createValidUser());
		Vacation vacation = vacationService.save(TestUtil.createUsingVacation(), "14-71017860");
		vacation.setStatus(VacationStatus.COMPLETED);
		HttpEntity<Vacation> requestEntity = new HttpEntity<>(vacation);
		putVacationsOfUser(user.getUsername(), requestEntity, Object.class);
	
		Vacation inDB = vacationRepository.findById(vacation.getNo()).get();
		assertThat(inDB.getStatus()).isEqualTo(VacationStatus.COMPLETED);
	}
	
	
	private <T> ResponseEntity<T> putVacationsOfUser(String username, HttpEntity<?> requestEntity, Class<T> responseType) {
		String path = API_1_0_VACATIONS + "/" + username;
		return testRestTemplate.exchange(path, HttpMethod.PUT, requestEntity, responseType);
	}
	
	private <T> ResponseEntity<T> getVacationsOfMyUnit(String username, ParameterizedTypeReference<T> responseType) {
		String path = API_1_0_VACATIONS + "/" + username;
		return testRestTemplate.exchange(path, HttpMethod.GET, null, responseType);
	}
	
	private <T> ResponseEntity<T> getVacations(ParameterizedTypeReference<T> responseType) {
		return testRestTemplate.exchange(API_1_0_VACATIONS, HttpMethod.GET, null, responseType);
	}
	
	private <T> ResponseEntity<T> postVacation(Vacation vacation, String username,  Class<T> responseType) {
		String url = API_1_0_VACATIONS + "/" + username;
		return testRestTemplate.postForEntity(url, vacation, responseType);
	}

	private void authenticate() {
		testRestTemplate.withBasicAuth("14-71017860", "P4ssword");
	}
}
