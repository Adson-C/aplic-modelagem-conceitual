package com.adson.aplimc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidatiomError extends StandardErrror {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	
	
	public ValidatiomError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messasge) {
		errors.add(new FieldMessage(fieldName,messasge));
	}

}
