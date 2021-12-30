package com.capitolsolutions.ecommerce.services.products;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.capitolsolutions.ecommerce.products.builders.ProductBuilder;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.capitolsolutions.ecommerce.dao.repositories.products.ProductDao;
import com.capitolsolutions.ecommerce.model.entities.products.Product;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService productService = new ProductServiceImpl();
	
	@Mock
	private ProductDao productDao;

	/**
	 * Llamada a ProductService.findOneById con resultado OK
	 */
	@Test
	public void testFindOneById_01() {
		
		Product product = new Product();
		product.setProductId(0L);
		product.setName("name");
		
		Mockito
			.when(productDao.findOneById(Mockito.any(Long.class)))
			.thenReturn(product);
		
		//////
		
		ProductDTO productDtoIn = new ProductBuilder()
				.withProductId(0L)
				.build();

		ProductDTO productDtoOut = productService.findOneById(productDtoIn);
		
		assertNotNull(productDtoOut);
	}
	
	/**
	 * Llamada a ProductService.findOneById con error en parametros de entrada ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneById_02() {
		
		ProductDTO productDtoIn = new ProductBuilder()
				.build();

		ProductDTO productDtoOut = productService.findOneById(productDtoIn);
		
		assertNotNull(productDtoOut);
	}
	
	/**
	 * Llamada a ProductService.findOneById con error al no encontrar resultados ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneById_03() {
		
		Mockito
			.when(productDao.findOneById(Mockito.any(Long.class)))
			.thenReturn(null);
		
		//////
		
		ProductDTO productDtoIn = new ProductBuilder()
				.withProductId(0L)
				.build();

		ProductDTO productDtoOut = productService.findOneById(productDtoIn);
		
		assertNotNull(productDtoOut);
	}
	
	/**
	 * Llamada a ProductService.findAll con resultado OK
	 */
	@Test
	public void testFindAll_01() {
		
		List<Product> productList = new LinkedList<>();
		
		for (long i = 0; i < 3; i++) {
			Product product = new Product();
			product.setProductId(i);
			product.setName("name");
			
			productList.add(product);
		}
		
		Mockito
			.when(productDao.findAll())
			.thenReturn(productList);
		
		//////
		
		List<ProductDTO> productListDtoOut = productService.findAll();
		
		assertNotNull(productListDtoOut);
		assertFalse(productListDtoOut.isEmpty());
	}

}
