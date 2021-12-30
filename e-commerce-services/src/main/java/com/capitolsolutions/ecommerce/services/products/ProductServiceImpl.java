package com.capitolsolutions.ecommerce.services.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitolsolutions.ecommerce.products.builders.ProductBuilder;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.capitolsolutions.ecommerce.dao.repositories.products.ProductDaoTest;
import com.capitolsolutions.ecommerce.model.entities.products.Product;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;

/**
 * Servicio donde se encuentran las operaciones a disponibles
 * para la entidad 'productos'
 * 
 * @author carlhc91
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDaoTest productDao;

	/**
	 * Metodo para consultar un producto en base a su identificador.
	 * Se realiza la comprobacion de los datos de entrada.
	 * Consultamos mediante el repositorio dao.
	 * Transformamos la entidad devuelta mediante un builder.
	 * Devolvemos el pojo resultante. 
	 * @param productDtoIn - producto sobre el que queremos realizar la consulta
	 * @return - producto encontrado en BBDD
	 * @throws ServiceException Si el identificador de producto es nulo
	 * @throws ServiceException Si no se ha encontrado en BBDD
	 * @see ProductService
	 */
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
	
	/**
	 * Metodo para consultar el listado de productos disponibles.
	 * Consultamos mediante el repositorio dao.
	 * Transformamos la entidad devuelta mediante un builder.
	 * Devolvemos el pojo resultante. 
	 * @return - listado de productos encontrado en BBDD
	 * @see ProductService
	 */
	public List<ProductDTO> findAll() {
		List<Product> productListOut = productDao.findAll();

		List<ProductDTO> productListDtoOut = productListOut.stream()
			.map(product -> {
				ProductDTO productDtoOut = new ProductBuilder()
					.withProductId(product.getProductId())
					.withName(product.getName())
					.build();

				return productDtoOut;
			})
			.toList();

		return productListDtoOut;
	}

}
