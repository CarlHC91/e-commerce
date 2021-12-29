package com.capitolsolutions.ecommerce.dao.repositories.prices;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capitolsolutions.ecommerce.model.entities.prices.Price;

/**
 * Repositorio de la entidad 'precios'
 * 
 * @author carlhc91
 */
@Repository
public interface PriceDao extends JpaRepository<Price, Long> {

	/**
	 * Busca un 'precio' en base al identificador de precio
	 * 
	 * @param priceList - identificador de precio
	 * @return precio
	 */
	@Query("SELECT entity FROM Price entity WHERE entity.priceList = :priceList")
	public Price findOneById(@Param("priceList") Long priceList);

	/**
	 * Busca un 'precios' en base al identificador de grupo,
	 * identificador de producto, y fecha de consulta.
	 * Se devolverá el precio cuya prioridad sea mas alta
	 * 
	 * @param brandId   - identificador de grupo
	 * @param productId - identificador de producto
	 * @param queryDate - fecha de la consulta
	 * @return precio
	 */
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
	public Price findOneByFilter(@Param("brandId") Long brandId, @Param("productId") Long productId, @Param("queryDate") Date queryDate);

}