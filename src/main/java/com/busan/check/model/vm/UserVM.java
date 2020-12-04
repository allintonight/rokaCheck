package com.busan.check.model.vm;

import com.busan.check.model.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVM {
	
	private long no;
	private String username;
	private String name;
	private String unit;
	private String phone;
	private String parentsPhone;
	private int isAdmin;
	private String ranks;
	private String position;
	private String address;
	
	public UserVM(User user) {
		this.no = user.getNo();
		this.username = user.getUsername();
		this.name = user.getName();
		this.unit = user.getUnit();
		this.phone = user.getPhone();
		this.parentsPhone = user.getParentsPhone();
		this.isAdmin = user.getIsAdmin();
		this.ranks = user.getRanks();
		this.position = user.getPosition();
		this.address = user.getAddress();
	}
}