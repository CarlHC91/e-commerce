package com.capitolsolutions.ecommerce.services.prices;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capitolsolutions.ecommerce.prices.builders.PriceBuilder;
import com.capitolsolutions.ecommerce.prices.builders.PriceFilterBuilder;
import com.capitolsolutions.ecommerce.prices.pojos.PriceDTO;
import com.capitolsolutions.ecommerce.prices.pojos.PriceFilterDTO;
import com.capitolsolutions.ecommerce.products.builders.ProductBuilder;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.capitolsolutions.ecommerce.brands.builders.BrandBuilder;
import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.dao.repositories.prices.PriceDao;
import com.capitolsolutions.ecommerce.model.entities.prices.Price;
import com.capitolsolutions.ecommerce.services.brands.BrandService;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;
import com.capitolsolutions.ecommerce.services.products.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {

	@InjectMocks
	private PriceService priceService = new PriceServiceImpl();
	
	@Mock
	private PriceDao priceDao;

	@Mock
	private BrandService brandService;
	@Mock
	private ProductService productService;
	
	/**
	 * Llamada a PriceService.findOneById con resultado OK
	 */
	@Test
	public void testFindOneById_01() {
		
		Price price = new Price();
		price.setPriceList(0L);
		price.setBrandId(0L);
		price.setStartDate(new Date());
		price.setEndDate(new Date());
		price.setProductId(0L);
		price.setPriority(0L);
		price.setPrice(0.0);
		price.setCurr("EUR");
		
		Mockito
			.when(priceDao.findOneById(Mockito.any(Long.class)))
			.thenReturn(price);
		
		BrandDTO brandDtoOut = new BrandBuilder()
				.withBrandId(0L)
				.build();
		
		Mockito
			.when(brandService.findOneById(Mockito.any(BrandDTO.class)))
			.thenReturn(brandDtoOut);
		
		ProductDTO productDtoOut = new ProductBuilder()
				.withProductId(0L)
				.build();
		
		Mockito
			.when(productService.findOneById(Mockito.any(ProductDTO.class)))
			.thenReturn(productDtoOut);
		
		//////
		
		PriceDTO priceDtoIn = new PriceBuilder()
				.withPriceList(0L)
				.build();

		PriceDTO priceDtoOut = priceService.findOneById(priceDtoIn);
		
		assertNotNull(priceDtoOut);
	}
	
	/**
	 * Llamada a PriceService.findOneById con error en parametros de entrada ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneById_02() {
		
		PriceDTO priceDtoIn = new PriceBuilder()
				.build();

		PriceDTO priceDtoOut = priceService.findOneById(priceDtoIn);
		
		assertNotNull(priceDtoOut);
	}
	
	/**
	 * Llamada a PriceService.findOneById con error al no encontrar resultados ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneById_03() {
		
		Mockito
			.when(priceDao.findOneById(Mockito.any(Long.class)))
			.thenReturn(null);
		
		//////
		
		PriceDTO priceDtoIn = new PriceBuilder()
				.withPriceList(0L)
				.build();

		PriceDTO priceDtoOut = priceService.findOneById(priceDtoIn);
		
		assertNotNull(priceDtoOut);
	}
	
	/**
	 * Llamada a PriceService.findAll con resultado OK
	 */
	@Test
	public void testFindAll_01() {
		
		List<Price> priceList = new LinkedList<>();
		
		for (long i = 0; i < 3; i++) {
			Price price = new Price();
			price.setPriceList(i);
			price.setBrandId(0L);
			price.setStartDate(new Date());
			price.setEndDate(new Date());
			price.setProductId(0L);
			price.setPriority(0L);
			price.setPrice(0.0);
			price.setCurr("EUR");
			
			priceList.add(price);
		}
		
		Mockito
			.when(priceDao.findAll())
			.thenReturn(priceList);
		
		BrandDTO brandDtoOut = new BrandBuilder()
				.withBrandId(0L)
				.build();
		
		Mockito
			.when(brandService.findOneById(Mockito.any(BrandDTO.class)))
			.thenReturn(brandDtoOut);
		
		ProductDTO productDtoOut = new ProductBuilder()
				.withProductId(0L)
				.build();
		
		Mockito
			.when(productService.findOneById(Mockito.any(ProductDTO.class)))
			.thenReturn(productDtoOut);
		
		//////
		
		List<PriceDTO> priceListDtoOut = priceService.findAll();
		
		assertNotNull(priceListDtoOut);
		assertFalse(priceListDtoOut.isEmpty());
	}

	/**
	 * Llamada a PriceService.findOneByFilter con resultado OK
	 */
	@Test
	public void testFindOneByFilter_01() {
		
		Price price = new Price();
		price.setPriceList(0L);
		price.setBrandId(0L);
		price.setStartDate(new Date());
		price.setEndDate(new Date());
		price.setProductId(0L);
		price.setPriority(0L);
		price.setPrice(0.0);
		price.setCurr("EUR");
		
		Mockito
			.when(priceDao.findOneByFilter(Mockito.any(Long.class), Mockito.any(Long.class), Mockito.any(Date.class)))
			.thenReturn(price);
		
		BrandDTO brandDtoOut = new BrandBuilder()
				.withBrandId(0L)
				.build();
		
		Mockito
			.when(brandService.findOneById(Mockito.any(BrandDTO.class)))
			.thenReturn(brandDtoOut);
		
		ProductDTO productDtoOut = new ProductBuilder()
				.withProductId(0L)
				.build();
		
		Mockito
			.when(productService.findOneById(Mockito.any(ProductDTO.class)))
			.thenReturn(productDtoOut);
		
		//////
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
				.withBrand(brandDtoOut)
				.withProduct(productDtoOut)
				.withQueryDate(new Date())
				.build();

		PriceDTO priceDtoOut = priceService.findOneByFilter(priceFilterDtoIn);
		
		assertNotNull(priceDtoOut);
	}
	
	/**
	 * Llamada a PriceService.findOneByFilter con error en parametros de entrada ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneByFilter_02() {
		
		Price price = new Price();
		price.setPriceList(0L);
		price.setBrandId(0L);
		price.setStartDate(new Date());
		price.setEndDate(new Date());
		price.setProductId(0L);
		price.setPriority(0L);
		price.setPrice(0.0);
		price.setCurr("EUR");
		
		Mockito
			.when(priceDao.findOneByFilter(Mockito.any(Long.class), Mockito.any(Long.class), Mockito.any(Date.class)))
			.thenReturn(price);
		
		BrandDTO brandDtoOut = new BrandBuilder()
				.withBrandId(0L)
				.build();
		
		Mockito
			.when(brandService.findOneById(Mockito.any(BrandDTO.class)))
			.thenReturn(brandDtoOut);
		
		ProductDTO productDtoOut = new ProductBuilder()
				.withProductId(0L)
				.build();
		
		Mockito
			.when(productService.findOneById(Mockito.any(ProductDTO.class)))
			.thenReturn(productDtoOut);
		
		//////
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
				.withProduct(productDtoOut)
				.withQueryDate(new Date())
				.build();

		PriceDTO priceDtoOut = priceService.findOneByFilter(priceFilterDtoIn);
		
		assertNotNull(priceDtoOut);
	}
	
	/**
	 * Llamada a PriceService.findOneByFilter con error en parametros de entrada ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneByFilter_03() {
		
		Price price = new Price();
		price.setPriceList(0L);
		price.setBrandId(0L);
		price.setStartDate(new Date());
		price.setEndDate(new Date());
		price.setProductId(0L);
		price.setPriority(0L);
		price.setPrice(0.0);
		price.setCurr("EUR");
		
		Mockito
			.when(priceDao.findOneByFilter(Mockito.any(Long.class), Mockito.any(Long.class), Mockito.any(Date.class)))
			.thenReturn(price);
		
		BrandDTO brandDtoOut = new BrandBuilder()
				.withBrandId(0L)
				.build();
		
		Mockito
			.when(brandService.findOneById(Mockito.any(BrandDTO.class)))
			.thenReturn(brandDtoOut);
		
		ProductDTO productDtoOut = new ProductBuilder()
				.withProductId(0L)
				.build();
		
		Mockito
			.when(productService.findOneById(Mockito.any(ProductDTO.class)))
			.thenReturn(productDtoOut);
		
		//////
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
				.withBrand(brandDtoOut)
				.withQueryDate(new Date())
				.build();

		PriceDTO priceDtoOut = priceService.findOneByFilter(priceFilterDtoIn);
		
		assertNotNull(priceDtoOut);
	}
	
	/**
	 * Llamada a PriceService.findOneByFilter con error en parametros de entrada ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneByFilter_04() {
		
		Price price = new Price();
		price.setPriceList(0L);
		price.setBrandId(0L);
		price.setStartDate(new Date());
		price.setEndDate(new Date());
		price.setProductId(0L);
		price.setPriority(0L);
		price.setPrice(0.0);
		price.setCurr("EUR");
		
		Mockito
			.when(priceDao.findOneByFilter(Mockito.any(Long.class), Mockito.any(Long.class), Mockito.any(Date.class)))
			.thenReturn(price);
		
		BrandDTO brandDtoOut = new BrandBuilder()
				.withBrandId(0L)
				.build();
		
		Mockito
			.when(brandService.findOneById(Mockito.any(BrandDTO.class)))
			.thenReturn(brandDtoOut);
		
		ProductDTO productDtoOut = new ProductBuilder()
				.withProductId(0L)
				.build();
		
		Mockito
			.when(productService.findOneById(Mockito.any(ProductDTO.class)))
			.thenReturn(productDtoOut);
		
		//////
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
				.withBrand(brandDtoOut)
				.withProduct(productDtoOut)
				.build();

		PriceDTO priceDtoOut = priceService.findOneByFilter(priceFilterDtoIn);
		
		assertNotNull(priceDtoOut);
	}
	
	/**
	 * Llamada a PriceService.findOneByFilter con error al no encontrar resultados ERROR
	 */
	@Test(expected = ServiceException.class)
	public void testFindOneByFilter_05() {
		
		Mockito
			.when(priceDao.findOneByFilter(Mockito.any(Long.class), Mockito.any(Long.class), Mockito.any(Date.class)))
			.thenReturn(null);
		
		BrandDTO brandDtoOut = new BrandBuilder()
				.withBrandId(0L)
				.build();
		
		Mockito
			.when(brandService.findOneById(Mockito.any(BrandDTO.class)))
			.thenReturn(brandDtoOut);
		
		ProductDTO productDtoOut = new ProductBuilder()
				.withProductId(0L)
				.build();
		
		Mockito
			.when(productService.findOneById(Mockito.any(ProductDTO.class)))
			.thenReturn(productDtoOut);
		
		//////
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
				.withBrand(brandDtoOut)
				.withProduct(productDtoOut)
				.withQueryDate(new Date())
				.build();

		PriceDTO priceDtoOut = priceService.findOneByFilter(priceFilterDtoIn);
		
		assertNotNull(priceDtoOut);
	}
	
}
