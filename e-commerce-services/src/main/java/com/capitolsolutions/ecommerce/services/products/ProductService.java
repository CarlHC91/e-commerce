package com.capitolsolutions.ecommerce.services.products;

import java.util.List;

import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;

/**
 * Interfaz donde se encuentran las operaciones a disponibles
 * para la entidad 'productos'
 * 
 * @author carlhc91
 */
public interface ProductService {

	/**
	 * Metodo para consultar un producto en base a su identificador.
	 * @param productDtoIn - producto sobre el que queremos realizar la consulta
	 * @return - producto encontrado en BBDD
	 */
	public ProductDTO findOneById(ProductDTO productDtoIn);
	
	/**
	 * Metodo para consultar el listado de productos disponibles.
	 * @return - listado de productos encontrado en BBDD
	 */
	public List<ProductDTO> findAll();

}
