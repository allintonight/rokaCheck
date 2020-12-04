package com.busan.check.model.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;

import com.busan.check.model.VacationStatus;

public class VacationStatusConverter implements AttributeConverter<VacationStatus, String> {
	@Override
	public String convertToDatabaseColumn(VacationStatus status) {
		if (status == null) {
			return null;
		}
		return status.getCode();
	}

	@Override
	public VacationStatus convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}
		
		return Stream.of(VacationStatus.values())
				.filter(i -> i.getCode().equals(code))
				.findFirst().orElseThrow(IllegalArgumentException::new);
	}
}
