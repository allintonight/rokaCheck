package com.busan.check.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
	
	@Id
	@Column(nullable = false, updatable = false, columnDefinition = "INT(11)")
	private long id;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Vacation> vacations;
	
	@OneToOne
	private EyeCheck eyeCheck;
	
	@Column(length = 100)
	private String unit;
	
	@Column(length = 10)
	private String username;
	
	@Column(length = 15)
	private String phone;
	
	@Column(length = 15)
	private String parentsPhone;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
	private int isAdmin;
	
	@Column(length = 11)
	private String ranks;
	
	@Column(length = 20)
	private String position;
	
	@Column(length = 100)
	private String adress;
	
}