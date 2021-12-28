package com.capitolsolutions.ecommerce.app.brands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.services.brands.BrandService;

@RestController
public class BrandRest {

	@Autowired
	private BrandService brandService;

	@GetMapping(produces = "application/json", consumes = "application/json", value = "/brands/findOneById")
	public ResponseEntity<BrandDTO> findOneById(RequestEntity<BrandDTO> requestEntityDto) {
		BrandDTO brandDtoIn = requestEntityDto.getBody();

		BrandDTO brandDtoOut = brandService.findOneById(brandDtoIn);

		return ResponseEntity.ok(brandDtoOut);
	}
	
	@GetMapping(produces = "application/json", consumes = "application/json", value = "/brands/findAll")
	public ResponseEntity<List<BrandDTO>> findAll() {

		List<BrandDTO> brandListDtoOut = brandService.findAll();

		return ResponseEntity.ok(brandListDtoOut);
	}

}
