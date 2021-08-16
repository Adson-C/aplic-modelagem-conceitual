package com.adson.aplimc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidatiomError extends StandardErrror {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidatiomError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messasge) {
		errors.add(new FieldMessage(fieldName,messasge));
	}

}
