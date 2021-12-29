package com.capitolsolutions.ecommerce.dao.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capitolsolutions.ecommerce.model.entities.products.Product;

/**
 * Repositorio de la entidad 'productos'
 * 
 * @author carlhc91
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

	/**
	 * Busca un 'producto' en base al identificador de producto
	 * 
	 * @param productId - identificador de producto
	 * @return producto
	 */
	@Query("SELECT entity FROM Product entity WHERE entity.productId = :productId")
	public Product findOneById(@Param("productId") Long productId);

}