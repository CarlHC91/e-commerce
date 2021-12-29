package com.capitolsolutions.ecommerce.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.capitolsolutions.ecommerce.services.products.ProductService;

/**
 * Controlador Rest donde se recibiran las peticiones relacionadas con
 * la entidad 'productos'
 * 
 * @author carlhc91
 */
@RestController
public class ProductRest {

	@Autowired
	private ProductService productService;

	/**
	 * Metodo POST que recibira en el body de la peticion el identificador de producto
	 * y realizara la llamada a la busqueda por identificador del servicio
	 * @param requestEntityDto - request que contiene el identificador de producto
	 * @return respuesta 200 OK si todo va bien, con el producto encontrado en BBDD
	 */
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/products/findOneById")
	public ResponseEntity<ProductDTO> findOneById(RequestEntity<ProductDTO> requestEntityDto) {
		ProductDTO productDtoIn = requestEntityDto.getBody();

		ProductDTO productDtoOut = productService.findOneById(productDtoIn);

		return ResponseEntity.ok(productDtoOut);
	}
	
	/**
	 * Metodo POST que recibira un body vacio
	 * y realizara la llamada a la busqueda del listado de productos del servicio
	 * @param requestEntityDto - request vacia
	 * @return respuesta 200 OK si todo va bien, con el listado de productos encontrados en BBDD
	 */
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/products/findAll")
	public ResponseEntity<List<ProductDTO>> findAll() {

		List<ProductDTO> productListDtoOut = productService.findAll();

		return ResponseEntity.ok(productListDtoOut);
	}

}
