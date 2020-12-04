package com.busan.check.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.busan.check.constraint.CheckOutIsAfterCheckIn;
import com.busan.check.model.converter.VacationStatusConverter;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@CheckOutIsAfterCheckIn
public class Vacation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	@Column(columnDefinition = "DATE")
	private LocalDate checkin;
	
	@Column(columnDefinition = "DATE")
	private LocalDate checkout;
	
	@Column(length = 20)
	@Convert(converter = VacationStatusConverter.class)
	private VacationStatus status;
	
	@ManyToOne
	private User user;
	
}