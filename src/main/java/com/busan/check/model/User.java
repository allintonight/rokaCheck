package com.busan.check.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamicInsert
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int no;
	
	@Column(length = 20, unique = true )
	private String username;
	
	@Column(length = 150)
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Vacation> vacations;
	
	@OneToOne
	private EyeCheck eyeCheck;
	
	@Column(length = 100)
	private String unit;
	
	@Column(length = 10)
	private String name;
	
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
	private String address;
	
	@ColumnDefault( "0")
	private String  depression;
	
	@ColumnDefault("0")
	private String tire;
	
}