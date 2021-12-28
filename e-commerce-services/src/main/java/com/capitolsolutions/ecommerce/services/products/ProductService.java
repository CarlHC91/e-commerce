package com.capitolsolutions.ecommerce.services.products;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitolsolutions.ecommerce.products.builders.ProductBuilder;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.capitolsolutions.ecommerce.dao.repositories.products.ProductDao;
import com.capitolsolutions.ecommerce.model.entities.products.Product;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public ProductDTO findOneById(ProductDTO productDtoIn) {
		if (productDtoIn.getProductId() == null) {
			throw new ServiceException("ProductId must not be null");
		}

		Product product = productDao.findOneById(productDtoIn.getProductId());
		if (product == null) {
			throw new ServiceException("Product not exists");
		}
		
		ProductDTO productDtoOut = new ProductBuilder()
				.withProductId(product.getProductId())
				.withName(product.getName())
				.build();
		
		return productDtoOut;
	}
	
	public List<ProductDTO> findAll() {
		List<ProductDTO> productListDtoOut = new LinkedList<>();
		
		for (Product product: productDao.findAll()) {
			ProductDTO productDtoOut = new ProductBuilder()
					.withProductId(product.getProductId())
					.withName(product.getName())
					.build();

			productListDtoOut.add(productDtoOut);
		}

		return productListDtoOut;
	}

}
