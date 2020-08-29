package com.products.restapi.error;

public class ResourceNotFoundDetails {

	private String title;
	private int status;
	private String detail;
	private long timestamp;
	private String developerMesssage;
	
	public ResourceNotFoundDetails() {}
	
	public ResourceNotFoundDetails(String title, int status, String detail, long timestamp, String developerMesssage) {
		super();
		this.title = title;
		this.status = status;
		this.detail = detail;
		this.timestamp = timestamp;
		this.developerMesssage = developerMesssage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDeveloperMesssage() {
		return developerMesssage;
	}

	public void setDeveloperMesssage(String developerMesssage) {
		this.developerMesssage = developerMesssage;
	}
}
