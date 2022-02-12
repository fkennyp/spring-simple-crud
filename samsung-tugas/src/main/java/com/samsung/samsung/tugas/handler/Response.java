package com.samsung.samsung.tugas.handler;

import java.util.List;

public class Response {
	private int status;
	private String message;
	private Object data;
	private List<Object> listOfData;

	public Response(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Response(int status, String message, List<Object> listOfData) {
		super();
		this.status = status;
		this.message = message;
		this.listOfData = listOfData;
	}

	public Response(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Response(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
