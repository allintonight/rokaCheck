package com.busan.check.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CheckOutAfterValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckOutIsAfterCheckIn {
	String message() default "{check.constraints.Vacation.CheckOutIsAfterCheckIn.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
