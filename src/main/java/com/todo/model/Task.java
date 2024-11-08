package com.todo.model;

public class Task {
	private Integer id;
	private String description;
	private String status;

	public Task() {

	}

	public Task( String description, String status) {
		super();
		
		this.description = description;
		setStatus(status);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status.equalsIgnoreCase("pending") || status.equalsIgnoreCase("completed")) {
			this.status = status;
		} else {
			throw new IllegalArgumentException("Invalid status");
		}
	}

}
