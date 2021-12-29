package com.capitolsolutions.ecommerce.services.exceptions;

/**
 * Excepcion de tipo Runtime para poder lanzar errores en la capa service
 * 
 * @author carlhc91
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
