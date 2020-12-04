package com.busan.check.model;

public enum VacationStatus {
	HAVING("H"),
	USING("U"),
	COMPLETED("C");
	
	private String code;
	
	private VacationStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
