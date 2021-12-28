package com.capitolsolutions.ecommerce.services.prices;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitolsolutions.ecommerce.prices.builders.PriceBuilder;
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

@Service
public class PriceService {

	@Autowired
	private PriceDao priceDao;

	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;

	public PriceDTO findOneById(PriceDTO priceDtoIn) {
		if (priceDtoIn.getPriceList() == null) {
			throw new ServiceException("PriceList must not be null");
		}

		Price price = priceDao.findOneById(priceDtoIn.getPriceList());
		if (price == null) {
			throw new ServiceException("Price not exists");
		}
		
		BrandDTO brandDtoOut = null;
		if (price.getBrandId() != null) {
			brandDtoOut = callBrandServiceFindOneById(price.getBrandId());
		}
		
		ProductDTO productDtoOut = null;
		if (price.getProductId() != null) {
			productDtoOut = callProductServiceFindOneById(price.getProductId());
		}
		
		PriceDTO priceDtoOut = new PriceBuilder()
				.withPriceList(price.getPriceList())
				.withBrand(brandDtoOut)
				.withStartDate(price.getStartDate())
				.withEndDate(price.getEndDate())
				.withProduct(productDtoOut)
				.withPriority(price.getPriority())
				.withPrice(price.getPrice())
				.withCurr(price.getCurr())
				.build();
		
		return priceDtoOut;
	}
	
	public List<PriceDTO> findAll() {
		List<PriceDTO> priceListDtoOut = new LinkedList<>();
		
		for (Price price: priceDao.findAll()) {
			BrandDTO brandDtoOut = null;
			if (price.getBrandId() != null) {
				brandDtoOut = callBrandServiceFindOneById(price.getBrandId());
			}
			
			ProductDTO productDtoOut = null;
			if (price.getProductId() != null) {
				productDtoOut = callProductServiceFindOneById(price.getProductId());
			}
			
			PriceDTO priceDtoOut = new PriceBuilder()
					.withPriceList(price.getPriceList())
					.withBrand(brandDtoOut)
					.withStartDate(price.getStartDate())
					.withEndDate(price.getEndDate())
					.withProduct(productDtoOut)
					.withPriority(price.getPriority())
					.withPrice(price.getPrice())
					.withCurr(price.getCurr())
					.build();

			priceListDtoOut.add(priceDtoOut);
		}

		return priceListDtoOut;
	}
	
	public List<PriceDTO> findAllByFilter(PriceFilterDTO priceFilterDtoIn) {
		if (priceFilterDtoIn.getBrand() == null || priceFilterDtoIn.getBrand().getBrandId() == null) {
			throw new ServiceException("BrandId must not be null");
		}
		BrandDTO brandDtoIn = priceFilterDtoIn.getBrand();
		
		if (priceFilterDtoIn.getProduct() == null || priceFilterDtoIn.getProduct().getProductId() == null) {
			throw new ServiceException("ProductId must not be null");
		}
		ProductDTO productDtoIn = priceFilterDtoIn.getProduct();
		
		if (priceFilterDtoIn.getQueryDate() == null) {
			throw new ServiceException("QueryDate must not be null");
		}
		
		List<PriceDTO> priceListDtoOut = new LinkedList<>();
		
		for (Price price: priceDao.findAllByFilter(brandDtoIn.getBrandId(), productDtoIn.getProductId(), priceFilterDtoIn.getQueryDate())) {
			BrandDTO brandDtoOut = null;
			if (price.getBrandId() != null) {
				brandDtoOut = callBrandServiceFindOneById(price.getBrandId());
			}
			
			ProductDTO productDtoOut = null;
			if (price.getProductId() != null) {
				productDtoOut = callProductServiceFindOneById(price.getProductId());
			}
			
			PriceDTO priceDtoOut = new PriceBuilder()
					.withPriceList(price.getPriceList())
					.withBrand(brandDtoOut)
					.withStartDate(price.getStartDate())
					.withEndDate(price.getEndDate())
					.withProduct(productDtoOut)
					.withPriority(price.getPriority())
					.withPrice(price.getPrice())
					.withCurr(price.getCurr())
					.build();

			priceListDtoOut.add(priceDtoOut);
		}

		return priceListDtoOut;
	}

	private BrandDTO callBrandServiceFindOneById(Long brandId) {
		BrandDTO brandDtoIn = new BrandBuilder()
				.withBrandId(brandId)
				.build();
		
		BrandDTO brandDtoOut = brandService.findOneById(brandDtoIn);

		return brandDtoOut;
	}
	
	private ProductDTO callProductServiceFindOneById(Long productId) {
		ProductDTO productDtoIn = new ProductBuilder()
				.withProductId(productId)
				.build();
		
		ProductDTO productDtoOut = productService.findOneById(productDtoIn);

		return productDtoOut;
	}

}
