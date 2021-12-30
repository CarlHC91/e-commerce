package com.capitolsolutions.ecommerce.app.handlers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capitolsolutions.ecommerce.errors.builders.ErrorBuilder;
import com.capitolsolutions.ecommerce.errors.pojos.ErrorDTO;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;

/**
 * Manejador de excepciones Rest donde se recibiran las peticiones fallidas
 * por la excepcion ServiceException
 * 
 * @author carlhc91
 */
@RestControllerAdvice
public class ExceptionRestHandler {


	/**
	 * Metodo que recibira La excepcion, que se encapsulara sobre un pojo 'error'
	 * y sera devuelto en la salida
	 * @param ex - excepcion ServiceExcepcion capturada por la aplicacion
	 * @return respuesta 400 BAD REQUEST como error, indicando la causa
	 */
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorDTO> parseServiceException(ServiceException ex) {

		ErrorDTO errorDtoOut = new ErrorBuilder()
			.withMessage(ex.getMessage())
			.build();

		return ResponseEntity.badRequest().body(errorDtoOut);
	}

}
