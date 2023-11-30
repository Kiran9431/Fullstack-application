package com.emp.response;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {
	Object data;
	String message;
	HttpStatus status;

	public Response() {
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
