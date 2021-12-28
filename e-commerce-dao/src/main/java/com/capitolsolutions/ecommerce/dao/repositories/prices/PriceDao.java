package com.capitolsolutions.ecommerce.dao.repositories.prices;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capitolsolutions.ecommerce.model.entities.prices.Price;

@Repository
public interface PriceDao extends JpaRepository<Price, Long> {

	@Query("SELECT entity FROM Price entity WHERE entity.priceList = :priceList")
	public Price findOneById(@Param("priceList") Long priceList);
	
	@Query("SELECT entity FROM Price entity"
		+ " WHERE entity.brandId = :brandId"
		+ " AND entity.productId = :productId"
		+ " AND entity.startDate < :queryDate"
		+ " AND entity.endDate > :queryDate"
		+ " AND entity.priority IN ("
			+ "SELECT MAX(entity.priority) FROM Price entity"
			+ " WHERE entity.brandId = :brandId"
			+ " AND entity.productId = :productId"
			+ " AND entity.startDate < :queryDate"
			+ " AND entity.endDate > :queryDate)")
	public List<Price> findAllByFilter(@Param("brandId") Long brandId, @Param("productId") Long productId, @Param("queryDate") Date queryDate);

}