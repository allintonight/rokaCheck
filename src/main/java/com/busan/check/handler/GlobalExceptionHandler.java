package com.busan.check.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.busan.check.dto.ResponseDto;
import com.busan.check.error.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request) {
		ApiError apiError = new ApiError(400, "부적절한 입력값", request.getServletPath());
		
		BindingResult result = exception.getBindingResult();
		Map<String, String> validationsErrors = new HashMap<>();
		
		for (FieldError fieldError : result.getFieldErrors()) {
			validationsErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		apiError.setValidationsErrors(validationsErrors);
		return apiError;
	}
	
	@ExceptionHandler({IllegalArgumentException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public GenericResponse handleIllegalAragumentException(IllegalArgumentException exception) {
		return new GenericResponse(exception.getMessage());
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseDto<String> handleArgumentException(Exception e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
}
