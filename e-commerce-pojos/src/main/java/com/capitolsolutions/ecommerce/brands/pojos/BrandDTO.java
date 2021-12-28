package com.capitolsolutions.ecommerce.brands.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrandDTO {

	@JsonProperty("brand_id")
	private Long brandId;

	@JsonProperty("name")
	private String name;

	public BrandDTO(Long brandId, String name) {
		this.brandId = brandId;
		this.name = name;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
