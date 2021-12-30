package com.capitolsolutions.ecommerce.app.prices;

import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.capitolsolutions.ecommerce.brands.builders.BrandBuilder;
import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.prices.builders.PriceBuilder;
import com.capitolsolutions.ecommerce.prices.builders.PriceFilterBuilder;
import com.capitolsolutions.ecommerce.prices.pojos.PriceDTO;
import com.capitolsolutions.ecommerce.prices.pojos.PriceFilterDTO;
import com.capitolsolutions.ecommerce.products.builders.ProductBuilder;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;
import com.capitolsolutions.ecommerce.services.prices.PriceService;

@RunWith(MockitoJUnitRunner.class)
public class PriceRestTest {

	@InjectMocks
	private PriceRest priceRest = new PriceRest();
	
	@Mock
	private PriceService priceService;

	/**
	 * Llamada a PriceRest.findOneById con resultado OK
	 */
	@Test
	public void testFindOneById_01() throws Exception {
		
		PriceDTO priceDtoOut = new PriceBuilder()
			.withPriceList(0L)
			.build();
		
		Mockito
			.when(priceService.findOneById(Mockito.any(PriceDTO.class)))
			.thenReturn(priceDtoOut);
		
		//////
		
		PriceDTO priceDtoIn = new PriceBuilder()
			.withPriceList(0L)
			.build();
		
		RequestEntity<PriceDTO> request = new RequestEntity<>(priceDtoIn, HttpMethod.POST, new URI("/prices/findOneById"));

		ResponseEntity<PriceDTO> response = priceRest.findOneById(request);
		
		assertNotNull(response);
	}
	
	/**
	 * Llamada a PriceRest.findOneById con exception ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneById_02() throws Exception {
		
		Mockito
			.when(priceService.findOneById(Mockito.any(PriceDTO.class)))
			.thenThrow(new ServiceException());
		
		//////
		
		PriceDTO priceDtoIn = new PriceBuilder()
			.withPriceList(0L)
			.build();
		
		RequestEntity<PriceDTO> request = new RequestEntity<>(priceDtoIn, HttpMethod.POST, new URI("/prices/findOneById"));

		ResponseEntity<PriceDTO> response = priceRest.findOneById(request);
		
		assertNotNull(response);
	}
	
	/**
	 * Llamada a PriceRest.findAll con resultado OK
	 */
	@Test
	public void testFindAll_01() throws Exception {
		
		List<PriceDTO> priceListDtoOut = new LinkedList<>();
		
		for (long i = 0; i < 3; i++) {
			PriceDTO priceDtoOut = new PriceBuilder()
				.withPriceList(i)
				.build();
			
			priceListDtoOut.add(priceDtoOut);
		}
		
		Mockito
			.when(priceService.findAll())
			.thenReturn(priceListDtoOut);
		
		//////
		
		ResponseEntity<List<PriceDTO>> response = priceRest.findAll();
		
		assertNotNull(response);
	}
	
	/**
	 * Llamada a PriceRest.findall con exception ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindAll_02() throws Exception {
		
		Mockito
			.when(priceService.findAll())
			.thenThrow(new ServiceException());
		
		//////
		
		ResponseEntity<List<PriceDTO>> response = priceRest.findAll();
		
		assertNotNull(response);
	}

	/**
	 * Llamada a PriceRest.findOneByFilter con resultado OK
	 */
	@Test
	public void testFindOneByFilter_01() throws Exception {
		
		PriceDTO priceDtoOut = new PriceBuilder()
			.withPriceList(0L)
			.build();
		
		Mockito
			.when(priceService.findOneByFilter(Mockito.any(PriceFilterDTO.class)))
			.thenReturn(priceDtoOut);
		
		//////
		
		BrandDTO brandDtoIn = new BrandBuilder()
				.withBrandId(0L)
				.build();
		
		ProductDTO productDtoIn = new ProductBuilder()
				.withProductId(0L)
				.build();
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
			.withBrand(brandDtoIn)
			.withProduct(productDtoIn)
			.withQueryDate(new Date())
			.build();
		
		RequestEntity<PriceFilterDTO> request = new RequestEntity<>(priceFilterDtoIn, HttpMethod.POST, new URI("/prices/findOneByFilter"));

		ResponseEntity<PriceDTO> response = priceRest.findOneByFilter(request);
		
		assertNotNull(response);
	}
	
	/**
	 * Llamada a PriceRest.findOneByFilter con exception ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneByFilter_02() throws Exception {
		
		Mockito
			.when(priceService.findOneByFilter(Mockito.any(PriceFilterDTO.class)))
			.thenThrow(new ServiceException());
		
		//////
		
		BrandDTO brandDtoIn = new BrandBuilder()
				.withBrandId(0L)
				.build();
		
		ProductDTO productDtoIn = new ProductBuilder()
				.withProductId(0L)
				.build();
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
			.withBrand(brandDtoIn)
			.withProduct(productDtoIn)
			.withQueryDate(new Date())
			.build();
		
		RequestEntity<PriceFilterDTO> request = new RequestEntity<>(priceFilterDtoIn, HttpMethod.POST, new URI("/prices/findOneByFilter"));

		ResponseEntity<PriceDTO> response = priceRest.findOneByFilter(request);
		
		assertNotNull(response);
	}

}
