package com.capitolsolutions.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capitolsolutions.ecommerce.app.prices.PriceRest;
import com.capitolsolutions.ecommerce.brands.builders.BrandBuilder;
import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.prices.builders.PriceFilterBuilder;
import com.capitolsolutions.ecommerce.prices.pojos.PriceDTO;
import com.capitolsolutions.ecommerce.prices.pojos.PriceFilterDTO;
import com.capitolsolutions.ecommerce.products.builders.ProductBuilder;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MainApplicationTest {

	@Autowired
	private PriceRest priceRest;
	
	// PRICE_ID		START_DATE				END_DATE				PRIORITY
	// 1			2020-06-14 00.00.00		2020-12-31 23.59.59		0
	// 2			2020-06-14 15.00.00		2020-06-14 18.30.00		1
	// 3			2020-06-15 00.00.00		2020-06-15 11.00.00		1
	// 4			2020-06-15 16.00.00		2020-12-31 23.59.59		1

	/**
	 * Test 1: Peticion a las 10:00 del día 14 del producto 35455 para la brand 1
	 * Se espera como resultado el precio 1
	 */
	@Test
	public void findOneByFilter_01() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date queryDate = format.parse("2020-06-14 10:00:00");

		BrandDTO brandDtoIn = new BrandBuilder()
			.withBrandId(1L)
			.build();
		
		ProductDTO productDtoIn = new ProductBuilder()
			.withProductId(35455L)
			.build();
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
			.withQueryDate(queryDate)
			.withBrand(brandDtoIn)
			.withProduct(productDtoIn)
			.build();
		
		RequestEntity<PriceFilterDTO> request = new RequestEntity<>(priceFilterDtoIn, HttpMethod.POST, new URI("/prices/findOneByFilter"));

		ResponseEntity<PriceDTO> response = priceRest.findOneByFilter(request);
		
		assertEquals(1L, response.getBody().getPriceList());
	}
	
	/**
	 * Test 2: Peticion a las 16:00 del día 14 del producto 35455 para la brand 1
	 * Se espera como resultado el precio 2
	 */
	@Test
	public void findOneByFilter_02() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date queryDate = format.parse("2020-06-14 16:00:00");

		BrandDTO brandDtoIn = new BrandBuilder()
			.withBrandId(1L)
			.build();
		
		ProductDTO productDtoIn = new ProductBuilder()
			.withProductId(35455L)
			.build();
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
			.withQueryDate(queryDate)
			.withBrand(brandDtoIn)
			.withProduct(productDtoIn)
			.build();
		
		RequestEntity<PriceFilterDTO> request = new RequestEntity<>(priceFilterDtoIn, HttpMethod.POST, new URI("/prices/findOneByFilter"));

		ResponseEntity<PriceDTO> response = priceRest.findOneByFilter(request);
		
		assertEquals(2L, response.getBody().getPriceList());
	}
	
	/**
	 * Test 3: Peticion a las 21:00 del día 14 del producto 35455 para la brand 1
	 * Se espera como resultado el precio 1
	 */
	@Test
	public void findOneByFilter_03() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date queryDate = format.parse("2020-06-14 21:00:00");

		BrandDTO brandDtoIn = new BrandBuilder()
			.withBrandId(1L)
			.build();
		
		ProductDTO productDtoIn = new ProductBuilder()
			.withProductId(35455L)
			.build();
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
			.withQueryDate(queryDate)
			.withBrand(brandDtoIn)
			.withProduct(productDtoIn)
			.build();
		
		RequestEntity<PriceFilterDTO> request = new RequestEntity<>(priceFilterDtoIn, HttpMethod.POST, new URI("/prices/findOneByFilter"));

		ResponseEntity<PriceDTO> response = priceRest.findOneByFilter(request);
		
		assertEquals(1L, response.getBody().getPriceList());
	}
	
	/**
	 * Test 4: Peticion a las 10:00 del día 15 del producto 35455 para la brand 1
	 * Se espera como resultado el precio 3
	 */
	@Test
	public void findOneByFilter_04() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date queryDate = format.parse("2020-06-15 10:00:00");

		BrandDTO brandDtoIn = new BrandBuilder()
			.withBrandId(1L)
			.build();
		
		ProductDTO productDtoIn = new ProductBuilder()
			.withProductId(35455L)
			.build();
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
			.withQueryDate(queryDate)
			.withBrand(brandDtoIn)
			.withProduct(productDtoIn)
			.build();
		
		RequestEntity<PriceFilterDTO> request = new RequestEntity<>(priceFilterDtoIn, HttpMethod.POST, new URI("/prices/findOneByFilter"));

		ResponseEntity<PriceDTO> response = priceRest.findOneByFilter(request);
		
		assertEquals(3L, response.getBody().getPriceList());
	}
	
	/**
	 * Test 5: Peticion a las 21:00 del día 16 del producto 35455 para la brand 1
	 * Se espera como resultado el precio 4
	 */
	@Test
	public void findOneByFilter_05() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date queryDate = format.parse("2020-06-16 21:00:00");

		BrandDTO brandDtoIn = new BrandBuilder()
			.withBrandId(1L)
			.build();
		
		ProductDTO productDtoIn = new ProductBuilder()
			.withProductId(35455L)
			.build();
		
		PriceFilterDTO priceFilterDtoIn = new PriceFilterBuilder()
			.withQueryDate(queryDate)
			.withBrand(brandDtoIn)
			.withProduct(productDtoIn)
			.build();
		
		RequestEntity<PriceFilterDTO> request = new RequestEntity<>(priceFilterDtoIn, HttpMethod.POST, new URI("/prices/findOneByFilter"));

		ResponseEntity<PriceDTO> response = priceRest.findOneByFilter(request);
		
		assertEquals(4L, response.getBody().getPriceList());
	}

}
