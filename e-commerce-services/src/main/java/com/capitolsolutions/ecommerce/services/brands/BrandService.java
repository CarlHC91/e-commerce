package com.capitolsolutions.ecommerce.services.brands;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitolsolutions.ecommerce.brands.builders.BrandBuilder;
import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.dao.repositories.brands.BrandDao;
import com.capitolsolutions.ecommerce.model.entities.brands.Brand;
import com.capitolsolutions.ecommerce.services.exceptions.ServiceException;

@Service
public class BrandService {

	@Autowired
	private BrandDao brandDao;

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
	
	public List<BrandDTO> findAll() {
		List<BrandDTO> brandListDtoOut = new LinkedList<>();
		
		for (Brand brand: brandDao.findAll()) {
			BrandDTO brandDtoOut = new BrandBuilder()
					.withBrandId(brand.getBrandId())
					.withName(brand.getName())
					.build();

			brandListDtoOut.add(brandDtoOut);
		}

		return brandListDtoOut;
	}

}
