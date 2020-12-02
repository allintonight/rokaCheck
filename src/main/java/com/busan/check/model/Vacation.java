package com.busan.check.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Vacation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	@Column(columnDefinition = "DATE")
	private LocalDate checkIn;
	
	@Column(columnDefinition = "DATE")
	private LocalDate checkOut;
	
	@Column(length = 45)
	private String type;
	
	@Column(length = 20)
	private String status;
	
	@ManyToOne
	private User user;
	
}