package com.busan.check.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.busan.check.model.Vacation;

public class CheckOutAfterValidator implements ConstraintValidator<CheckOutIsAfterCheckIn, Vacation> {

	@Override
	public boolean isValid(Vacation vacation, ConstraintValidatorContext context) {
		if (vacation.getCheckin() == null || vacation.getCheckout() == null) {
			return false;
		}
		if (vacation.getCheckin().isBefore(vacation.getCheckout())) {
			return true;
		}
		return false;
	}

}
