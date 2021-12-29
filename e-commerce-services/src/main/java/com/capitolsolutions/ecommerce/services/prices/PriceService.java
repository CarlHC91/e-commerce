package com.capitolsolutions.ecommerce.services.prices;

import java.util.List;

import com.capitolsolutions.ecommerce.prices.pojos.PriceDTO;
import com.capitolsolutions.ecommerce.prices.pojos.PriceFilterDTO;

/**
 * Servicio donde se encuentran las operaciones a disponibles
 * para la entidad 'precios'
 * 
 * @author carlhc91
 */
public interface PriceService {

	/**
	 * Metodo para consultar un precio en base a su identificador.
	 * @param priceDtoIn - precio sobre el que queremos realizar la consulta
	 * @return - precio encontrado en BBDD
	 */
	public PriceDTO findOneById(PriceDTO priceDtoIn);
	
	/**
	 * Metodo para consultar el listado de precios disponibles.
	 * @return - listado de precios encontrado en BBDD
	 */
	public List<PriceDTO> findAll();
	
	/**
	 * Metodo para consultar un precio en base a un grupo, producto y fecha de consulta.
	 * @return - precio encontrado en BBDD
	 */
	public PriceDTO findOneByFilter(PriceFilterDTO priceFilterDtoIn);

}
