package com.capitolsolutions.ecommerce.model.entities.brands;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANDS")
public class Brand {

	@Id
	@Column(name = "BRAND_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandId;

	@Column(name = "NAME")
	private String name;

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
