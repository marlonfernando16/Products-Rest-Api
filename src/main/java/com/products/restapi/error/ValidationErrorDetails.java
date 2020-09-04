package com.products.restapi.error;

public class ValidationErrorDetails extends ErrorDetail{

	private String field;
	private String fieldMessage;
	
	public ValidationErrorDetails(String title, int status, String detail, long timestamp, String developerMesssage,String field,String fieldMessage) {
		super(title, status, detail, timestamp, developerMesssage);
		this.field = field;
		this.fieldMessage = fieldMessage;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}

	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}
	
}
