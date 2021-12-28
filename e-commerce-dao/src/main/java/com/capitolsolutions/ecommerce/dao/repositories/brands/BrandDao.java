package com.capitolsolutions.ecommerce.dao.repositories.brands;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capitolsolutions.ecommerce.model.entities.brands.Brand;

@Repository
public interface BrandDao extends JpaRepository<Brand, Long> {

	@Query("SELECT entity FROM Brand entity WHERE entity.brandId = :brandId")
	public Brand findOneById(@Param("brandId") Long brandId);
	
}