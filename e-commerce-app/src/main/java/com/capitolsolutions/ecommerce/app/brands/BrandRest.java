package com.capitolsolutions.ecommerce.app.brands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.services.brands.BrandService;

/**
 * Controlador Rest donde se recibiran las peticiones relacionadas con
 * la entidad 'grupos'
 * 
 * @author carlhc91
 */
@RestController
public class BrandRest {

	@Autowired
	private BrandService brandService;

	/**
	 * Metodo POST que recibira en el body de la peticion el identificador de grupo
	 * y realizara la llamada a la busqueda por identificador del servicio
	 * @param requestEntityDto - request que contiene el identificador de grupo
	 * @return respuesta 200 OK si todo va bien, con el grupo encontrado en BBDD
	 */
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/brands/findOneById")
	public ResponseEntity<BrandDTO> findOneById(RequestEntity<BrandDTO> requestEntityDto) {
		BrandDTO brandDtoIn = requestEntityDto.getBody();

		BrandDTO brandDtoOut = brandService.findOneById(brandDtoIn);

		return ResponseEntity.ok(brandDtoOut);
	}

	/**
	 * Metodo POST que recibira un body vacio
	 * y realizara la llamada a la busqueda del listado de grupos del servicio
	 * @param requestEntityDto - request vacia
	 * @return respuesta 200 OK si todo va bien, con el listado de grupos encontrados en BBDD
	 */
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/brands/findAll")
	public ResponseEntity<List<BrandDTO>> findAll() {

		List<BrandDTO> brandListDtoOut = brandService.findAll();

		return ResponseEntity.ok(brandListDtoOut);
	}

}
