package com.capitolsolutions.ecommerce.services.brands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitolsolutions.ecommerce.brands.builders.BrandBuilder;
import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.dao.repositories.brands.BrandDaoTest;
import com.capitolsolutions.ecommerce.model.entities.brands.Brand;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;

/**
 * Servicio donde se encuentran las operaciones a disponibles
 * para la entidad 'grupos'
 * 
 * @author carlhc91
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDaoTest brandDao;

	/**
	 * Metodo para consultar un grupo en base a su identificador.
	 * Se realiza la comprobacion de los datos de entrada.
	 * Consultamos mediante el repositorio dao.
	 * Transformamos la entidad devuelta mediante un builder.
	 * Devolvemos el pojo resultante. 
	 * @param brandDtoIn - grupo sobre el que queremos realizar la consulta
	 * @return - grupo encontrado en BBDD
	 * @throws ServiceException Si el identificador de grupo es nulo
	 * @throws ServiceException Si no se ha encontrado en BBDD
	 * @see BrandService
	 */
	public BrandDTO findOneById(BrandDTO brandDtoIn) {
		if (brandDtoIn.getBrandId() == null) {
			throw new ServiceException("BrandId must not be null");
		}

		Brand brand = brandDao.findOneById(brandDtoIn.getBrandId());
		if (brand == null) {
			throw new ServiceException("Brand not exists");
		}

		BrandDTO brandDtoOut = new BrandBuilder()
				.withBrandId(brand.getBrandId())
				.withName(brand.getName())
				.build();

		return brandDtoOut;
	}

	/**
	 * Metodo para consultar el listado de grupos disponibles.
	 * Consultamos mediante el repositorio dao.
	 * Transformamos la entidad devuelta mediante un builder.
	 * Devolvemos el pojo resultante. 
	 * @return - listado de grupos encontrado en BBDD
	 * @see BrandService
	 */
	public List<BrandDTO> findAll() {
		List<Brand> brandListOut = brandDao.findAll();

		List<BrandDTO> brandListDtoOut = brandListOut.stream()
			.map(brand -> {
				BrandDTO brandDtoOut = new BrandBuilder()
					.withBrandId(brand.getBrandId())
					.withName(brand.getName())
					.build();

				return brandDtoOut;
			})
			.toList();

		return brandListDtoOut;
	}

}
