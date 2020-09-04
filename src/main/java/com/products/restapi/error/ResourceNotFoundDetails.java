package com.products.restapi.error;

public class ResourceNotFoundDetails extends ErrorDetail{
		
	public ResourceNotFoundDetails(String title, int status, String detail, long timestamp, String developerMesssage) {
		super(title, status, detail, timestamp, developerMesssage);
	}
}
