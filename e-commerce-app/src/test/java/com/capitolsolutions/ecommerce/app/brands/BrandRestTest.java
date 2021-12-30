package com.capitolsolutions.ecommerce.app.brands;

import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.capitolsolutions.ecommerce.brands.builders.BrandBuilder;
import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.services.brands.BrandService;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;

@RunWith(MockitoJUnitRunner.class)
public class BrandRestTest {

	@InjectMocks
	private BrandRest brandRest = new BrandRest();
	
	@Mock
	private BrandService brandService;

	/**
	 * Llamada a BrandRest.findOneById con resultado OK
	 */
	@Test
	public void testFindOneById_01() throws Exception {
		
		BrandDTO brandDtoOut = new BrandBuilder()
			.withBrandId(0L)
			.build();
		
		Mockito
			.when(brandService.findOneById(Mockito.any(BrandDTO.class)))
			.thenReturn(brandDtoOut);
		
		//////
		
		BrandDTO brandDtoIn = new BrandBuilder()
			.withBrandId(0L)
			.build();
		
		RequestEntity<BrandDTO> request = new RequestEntity<>(brandDtoIn, HttpMethod.POST, new URI("/brands/findOneById"));

		ResponseEntity<BrandDTO> response = brandRest.findOneById(request);
		
		assertNotNull(response);
	}
	
	/**
	 * Llamada a BrandRest.findOneById con exception ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneById_02() throws Exception {
		
		Mockito
			.when(brandService.findOneById(Mockito.any(BrandDTO.class)))
			.thenThrow(new ServiceException());
		
		//////
		
		BrandDTO brandDtoIn = new BrandBuilder()
			.withBrandId(0L)
			.build();
		
		RequestEntity<BrandDTO> request = new RequestEntity<>(brandDtoIn, HttpMethod.POST, new URI("/brands/findOneById"));

		ResponseEntity<BrandDTO> response = brandRest.findOneById(request);
		
		assertNotNull(response);
	}
	
	/**
	 * Llamada a BrandRest.findAll con resultado OK
	 */
	@Test
	public void testFindAll_01() throws Exception {
		
		List<BrandDTO> brandListDtoOut = new LinkedList<>();
		
		for (long i = 0; i < 3; i++) {
			BrandDTO brandDtoOut = new BrandBuilder()
				.withBrandId(i)
				.build();
			
			brandListDtoOut.add(brandDtoOut);
		}
		
		Mockito
			.when(brandService.findAll())
			.thenReturn(brandListDtoOut);
		
		//////
		
		ResponseEntity<List<BrandDTO>> response = brandRest.findAll();
		
		assertNotNull(response);
	}

	/**
	 * Llamada a BrandRest.findAll con exception ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindAll_02() throws Exception {
		
		Mockito
			.when(brandService.findAll())
			.thenThrow(new ServiceException());
		
		//////
		
		ResponseEntity<List<BrandDTO>> response = brandRest.findAll();
		
		assertNotNull(response);
	}
	
}
