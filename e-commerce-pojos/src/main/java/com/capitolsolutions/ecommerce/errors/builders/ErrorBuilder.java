package com.capitolsolutions.ecommerce.errors.builders;

import com.capitolsolutions.ecommerce.errors.pojos.ErrorDTO;

public class ErrorBuilder {

	private String message;

	public ErrorBuilder withMessage(String message) {
		this.message = message;

		return this;
	}

	public ErrorDTO build() {
		return new ErrorDTO(message);
	}

}
