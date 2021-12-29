package com.capitolsolutions.ecommerce.app.prices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitolsolutions.ecommerce.prices.pojos.PriceDTO;
import com.capitolsolutions.ecommerce.prices.pojos.PriceFilterDTO;
import com.capitolsolutions.ecommerce.services.prices.PriceService;

/**
 * Controlador Rest donde se recibiran las peticiones relacionadas con
 * la entidad 'precios'
 * 
 * @author carlhc91
 */
@RestController
public class PriceRest {

	@Autowired
	private PriceService priceService;

	/**
	 * Metodo POST que recibira en el body de la peticion el identificador de precio
	 * y realizara la llamada a la busqueda por identificador del servicio
	 * @param requestEntityDto - request que contiene el identificador de precio
	 * @return respuesta 200 OK si todo va bien, con el precio encontrado en BBDD
	 */
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/prices/findOneById")
	public ResponseEntity<PriceDTO> findOneById(RequestEntity<PriceDTO> requestEntityDto) {
		PriceDTO priceDtoIn = requestEntityDto.getBody();

		PriceDTO priceDtoOut = priceService.findOneById(priceDtoIn);

		return ResponseEntity.ok(priceDtoOut);
	}
	
	/**
	 * Metodo POST que recibira un body vacio
	 * y realizara la llamada a la busqueda del listado de precios del servicio
	 * @param requestEntityDto - request vacia
	 * @return respuesta 200 OK si todo va bien, con el listado de precios encontrados en BBDD
	 */
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/prices/findAll")
	public ResponseEntity<List<PriceDTO>> findAll() {

		List<PriceDTO> priceListDtoOut = priceService.findAll();

		return ResponseEntity.ok(priceListDtoOut);
	}
	
	/**
	 * Metodo POST que recibira en el body de la peticion el identificador de grupo,
	 * identificador de producto y fecha de consulta,
	 * y realizara la llamada a la busqueda por filtro del servicio
	 * @param requestEntityDto - request que contiene el identificador de precio
	 * @return respuesta 200 OK si todo va bien, con el precio encontrado en BBDD
	 */
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/prices/findOneByFilter")
	public ResponseEntity<PriceDTO> findOneByFilter(RequestEntity<PriceFilterDTO> requestEntityDto) {
		PriceFilterDTO priceFilterDtoIn = requestEntityDto.getBody();

		PriceDTO priceDtoOut = priceService.findOneByFilter(priceFilterDtoIn);

		return ResponseEntity.ok(priceDtoOut);
	}

}
