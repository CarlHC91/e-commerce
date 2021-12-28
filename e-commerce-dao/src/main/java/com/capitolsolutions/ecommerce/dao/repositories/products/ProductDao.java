package com.capitolsolutions.ecommerce.dao.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capitolsolutions.ecommerce.model.entities.products.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

	@Query("SELECT entity FROM Product entity WHERE entity.productId = :productId")
	public Product findOneById(@Param("productId") Long productId);

}