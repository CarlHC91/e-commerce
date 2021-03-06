package com.capitolsolutions.ecommerce.app.products;

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

import com.capitolsolutions.ecommerce.products.builders.ProductBuilder;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;
import com.capitolsolutions.ecommerce.services.products.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductRestTest {

	@InjectMocks
	private ProductRest productRest = new ProductRest();
	
	@Mock
	private ProductService productService;

	/**
	 * Llamada a ProductRest.findOneById con resultado OK
	 */
	@Test
	public void testFindOneById_01() throws Exception {
		
		ProductDTO productDtoOut = new ProductBuilder()
			.withProductId(0L)
			.build();
		
		Mockito
			.when(productService.findOneById(Mockito.any(ProductDTO.class)))
			.thenReturn(productDtoOut);
		
		//////
		
		ProductDTO productDtoIn = new ProductBuilder()
			.withProductId(0L)
			.build();
		
		RequestEntity<ProductDTO> request = new RequestEntity<>(productDtoIn, HttpMethod.POST, new URI("/products/findOneById"));

		ResponseEntity<ProductDTO> response = productRest.findOneById(request);
		
		assertNotNull(response);
	}
	
	/**
	 * Llamada a ProductRest.findOneById con exception ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneById_02() throws Exception {
		
		Mockito
			.when(productService.findOneById(Mockito.any(ProductDTO.class)))
			.thenThrow(new ServiceException());
		
		//////
		
		ProductDTO productDtoIn = new ProductBuilder()
			.withProductId(0L)
			.build();
		
		RequestEntity<ProductDTO> request = new RequestEntity<>(productDtoIn, HttpMethod.POST, new URI("/products/findOneById"));

		ResponseEntity<ProductDTO> response = productRest.findOneById(request);
		
		assertNotNull(response);
	}
	
	/**
	 * Llamada a ProductRest.findAll con resultado OK
	 */
	@Test
	public void testFindAll_01() throws Exception {
		
		List<ProductDTO> productListDtoOut = new LinkedList<>();
		
		for (long i = 0; i < 3; i++) {
			ProductDTO productDtoOut = new ProductBuilder()
				.withProductId(i)
				.build();
			
			productListDtoOut.add(productDtoOut);
		}
		
		Mockito
			.when(productService.findAll())
			.thenReturn(productListDtoOut);
		
		//////
		
		ResponseEntity<List<ProductDTO>> response = productRest.findAll();
		
		assertNotNull(response);
	}
	
	/**
	 * Llamada a ProductRest.findAll con exception ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindAll_02() throws Exception {
		
		Mockito
			.when(productService.findAll())
			.thenThrow(new ServiceException());
		
		//////
		
		ResponseEntity<List<ProductDTO>> response = productRest.findAll();
		
		assertNotNull(response);
	}
	
}
