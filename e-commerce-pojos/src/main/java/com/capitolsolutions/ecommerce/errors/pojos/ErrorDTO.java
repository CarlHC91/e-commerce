package com.capitolsolutions.ecommerce.errors.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDTO {

	@JsonProperty("message")
	private String message;

	public ErrorDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
