package com.capitolsolutions.ecommerce.app.prices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitolsolutions.ecommerce.prices.pojos.PriceDTO;
import com.capitolsolutions.ecommerce.prices.pojos.PriceFilterDTO;
import com.capitolsolutions.ecommerce.services.prices.PriceService;

@RestController
public class PriceRest {

	@Autowired
	private PriceService priceService;

	@GetMapping(produces = "application/json", consumes = "application/json", value = "/prices/findOneById")
	public ResponseEntity<PriceDTO> findOneById(RequestEntity<PriceDTO> requestEntityDto) {
		PriceDTO priceDtoIn = requestEntityDto.getBody();

		PriceDTO priceDtoOut = priceService.findOneById(priceDtoIn);

		return ResponseEntity.ok(priceDtoOut);
	}
	
	@GetMapping(produces = "application/json", consumes = "application/json", value = "/prices/findAll")
	public ResponseEntity<List<PriceDTO>> findAll() {

		List<PriceDTO> priceListDtoOut = priceService.findAll();

		return ResponseEntity.ok(priceListDtoOut);
	}
	
	@GetMapping(produces = "application/json", consumes = "application/json", value = "/prices/findAllByFilter")
	public ResponseEntity<List<PriceDTO>> findAllByFilter(RequestEntity<PriceFilterDTO> requestEntityDto) {
		PriceFilterDTO priceFilterDtoIn = requestEntityDto.getBody();

		List<PriceDTO> priceListDtoOut = priceService.findAllByFilter(priceFilterDtoIn);

		return ResponseEntity.ok(priceListDtoOut);
	}

}
