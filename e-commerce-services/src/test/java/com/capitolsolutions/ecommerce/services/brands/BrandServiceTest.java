package com.capitolsolutions.ecommerce.services.brands;


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

import com.capitolsolutions.ecommerce.brands.builders.BrandBuilder;
import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.dao.repositories.brands.BrandDao;
import com.capitolsolutions.ecommerce.model.entities.brands.Brand;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;

@RunWith(MockitoJUnitRunner.class)
public class BrandServiceTest {

	@InjectMocks
	private BrandService brandService = new BrandServiceImpl();
	
	@Mock
	private BrandDao brandDao;

	/**
	 * Llamada a BrandService.findOneById con resultado OK
	 */
	@Test
	public void testFindOneById_01() {
		
		Brand brand = new Brand();
		brand.setBrandId(0L);
		brand.setName("name");
		
		Mockito
			.when(brandDao.findOneById(Mockito.any(Long.class)))
			.thenReturn(brand);
		
		//////
		
		BrandDTO brandDtoIn = new BrandBuilder()
				.withBrandId(0L)
				.build();

		BrandDTO brandDtoOut = brandService.findOneById(brandDtoIn);
		
		assertNotNull(brandDtoOut);
	}
	
	/**
	 * Llamada a BrandService.findOneById con error en parametros de entrada ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneById_02() {
		
		BrandDTO brandDtoIn = new BrandBuilder()
				.build();

		BrandDTO brandDtoOut = brandService.findOneById(brandDtoIn);
		
		assertNotNull(brandDtoOut);
	}
	
	/**
	 * Llamada a BrandService.findOneById con error al no encontrar resultados ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneById_03() {
		
		Mockito
			.when(brandDao.findOneById(Mockito.any(Long.class)))
			.thenReturn(null);
		
		//////
		
		BrandDTO brandDtoIn = new BrandBuilder()
				.withBrandId(0L)
				.build();

		BrandDTO brandDtoOut = brandService.findOneById(brandDtoIn);
		
		assertNotNull(brandDtoOut);
	}
	
	/**
	 * Llamada a BrandService.findAll con resultado OK
	 */
	@Test
	public void testFindAll_01() {
		
		List<Brand> brandList = new LinkedList<>();
		
		for (long i = 0; i < 3; i++) {
			Brand brand = new Brand();
			brand.setBrandId(i);
			brand.setName("name");
			
			brandList.add(brand);
		}
		
		Mockito
			.when(brandDao.findAll())
			.thenReturn(brandList);
		
		//////
		
		List<BrandDTO> brandListDtoOut = brandService.findAll();
		
		assertNotNull(brandListDtoOut);
		assertFalse(brandListDtoOut.isEmpty());
	}

}
