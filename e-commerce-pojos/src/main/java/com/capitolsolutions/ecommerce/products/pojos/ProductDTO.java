package com.capitolsolutions.ecommerce.products.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {

	@JsonProperty("product_id")
	private Long productId;

	@JsonProperty("name")
	private String name;

	public ProductDTO(Long productId, String name) {
		this.productId = productId;
		this.name = name;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
