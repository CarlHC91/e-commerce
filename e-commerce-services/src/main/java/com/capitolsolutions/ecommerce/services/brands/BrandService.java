package com.capitolsolutions.ecommerce.services.brands;

import java.util.List;

import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;

/**
 * Interfaz donde se encuentran las operaciones a disponibles
 * para la entidad 'grupos'
 * 
 * @author carlhc91
 */
public interface BrandService {

	/**
	 * Metodo para consultar un grupo en base a su identificador.
	 * @param brandDtoIn - grupo sobre el que queremos realizar la consulta
	 * @return - grupo encontrado en BBDD
	 */
	public BrandDTO findOneById(BrandDTO brandDtoIn);

	/**
	 * Metodo para consultar el listado de grupos disponibles.
	 * @return - listado de grupos encontrado en BBDD
	 */
	public List<BrandDTO> findAll();

}
