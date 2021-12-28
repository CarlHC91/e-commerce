package com.capitolsolutions.ecommerce.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.capitolsolutions.ecommerce.services.products.ProductService;

@RestController
public class ProductRest {

	@Autowired
	private ProductService productService;

	@GetMapping(produces = "application/json", consumes = "application/json", value = "/products/findOneById")
	public ResponseEntity<ProductDTO> findOneById(RequestEntity<ProductDTO> requestEntityDto) {
		ProductDTO productDtoIn = requestEntityDto.getBody();

		ProductDTO productDtoOut = productService.findOneById(productDtoIn);

		return ResponseEntity.ok(productDtoOut);
	}
	
	@GetMapping(produces = "application/json", consumes = "application/json", value = "/products/findAll")
	public ResponseEntity<List<ProductDTO>> findAll() {

		List<ProductDTO> productListDtoOut = productService.findAll();

		return ResponseEntity.ok(productListDtoOut);
	}

}
