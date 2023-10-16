package edu.cesur.employee.services.validators;

import java.util.regex.Pattern;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomValidation, String>{
	//definimos el patrón con java regex
		private static final Pattern CODE_PATTERN = Pattern.compile("EMP-[a-z]{3}-\\\\d{4}");

		@Override
		public void initialize(CustomValidation constraintAnnotation) {
		}

		@Override
		public boolean isValid(String code, ConstraintValidatorContext context) {
			if (code == null) {
				return false;
			}
			return CODE_PATTERN.matcher(code).matches(); 
		}
}
