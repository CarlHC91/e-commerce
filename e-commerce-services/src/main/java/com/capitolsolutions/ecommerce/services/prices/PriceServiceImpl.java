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

/**
 * Servicio donde se encuentran las operaciones a disponibles
 * para la entidad 'precios'
 * 
 * @author carlhc91
 */
@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceDao priceDao;

	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;

	/**
	 * Metodo para consultar un precio en base a su identificador.
	 * Se realiza la comprobacion de los datos de entrada.
	 * Consultamos mediante el repositorio dao.
	 * Transformamos la entidad devuelta mediante un builder.
	 * Devolvemos el pojo resultante. 
	 * @param priceDtoIn - precio sobre el que queremos realizar la consulta
	 * @return - precio encontrado en BBDD
	 * @throws ServiceException Si el identificador de precio es nulo
	 * @throws ServiceException Si no se ha encontrado en BBDD
	 * @see PriceService
	 */
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
	
	/**
	 * Metodo para consultar el listado de precios disponibles.
	 * Consultamos mediante el repositorio dao.
	 * Transformamos la entidad devuelta mediante un builder.
	 * Devolvemos el pojo resultante. 
	 * @return - listado de precios encontrado en BBDD
	 * @see PriceService
	 */
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
	
	/**
	 * Metodo para consultar un precio en base a un grupo, producto y fecha de consulta.
	 * Consultamos mediante el repositorio dao.
	 * Transformamos la entidad devuelta mediante un builder.
	 * Devolvemos el pojo resultante. 
	 * @return - precio encontrado en BBDD
	 * @throws ServiceException Si el identificador de grupo es nulo
	 * @throws ServiceException Si el identificador de producto es nulo
	 * @throws ServiceException Si la fecha de consulta es nula
	 * @throws ServiceException Si no se ha encontrado en BBDD
	 * @see PriceService
	 */
	public PriceDTO findOneByFilter(PriceFilterDTO priceFilterDtoIn) {
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
		
		Price price = priceDao.findOneByFilter(brandDtoIn.getBrandId(), productDtoIn.getProductId(), priceFilterDtoIn.getQueryDate());
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

	/**
	 * Metodo privado para poder recumerar un grupo llamando al servicio de grupos
	 * @return - grupo encontrado en BBDD
	 */
	private BrandDTO callBrandServiceFindOneById(Long brandId) {
		BrandDTO brandDtoIn = new BrandBuilder()
				.withBrandId(brandId)
				.build();
		
		BrandDTO brandDtoOut = brandService.findOneById(brandDtoIn);

		return brandDtoOut;
	}
	
	/**
	 * Metodo privado para poder recumerar un producto llamando al servicio de productos
	 * @return - grupo encontrado en BBDD
	 */
	private ProductDTO callProductServiceFindOneById(Long productId) {
		ProductDTO productDtoIn = new ProductBuilder()
				.withProductId(productId)
				.build();
		
		ProductDTO productDtoOut = productService.findOneById(productDtoIn);

		return productDtoOut;
	}

}
