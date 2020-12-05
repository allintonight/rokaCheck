package com.busan.check.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
	

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	@Entity
	public class Security {
			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id;
			
			@Column(nullable = false, length=20)
			private String username;
			
			@Column(nullable = false, length=10)
			private String name;
			
			@Enumerated(EnumType.STRING)
			private  Location location;
			
			@CreationTimestamp
			private Timestamp checkin;
			
			@UpdateTimestamp
			private Timestamp checkout;
			
			
			public enum Location {
				weapon,
				bullet,
				security
			}
}
	
