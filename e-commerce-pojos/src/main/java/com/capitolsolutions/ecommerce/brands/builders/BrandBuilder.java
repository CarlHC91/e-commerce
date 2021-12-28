package com.capitolsolutions.ecommerce.brands.builders;

import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;

public class BrandBuilder {

	private Long brandId;
	private String name;

	public BrandBuilder withBrandId(Long brandId) {
		this.brandId = brandId;

		return this;
	}

	public BrandBuilder withName(String name) {
		this.name = name;

		return this;
	}

	public BrandDTO build() {
		return new BrandDTO(brandId, name);
	}

}
