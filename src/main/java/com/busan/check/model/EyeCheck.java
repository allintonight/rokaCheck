package com.busan.check.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class EyeCheck {
	
	@Id
	private long id;
	
	@Column(length = 1000)
	private String image;
	
	@OneToOne(mappedBy = "eyeCheck")
	private User user;
}