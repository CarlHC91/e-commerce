package com.capitolsolutions.ecommerce.products.builders;

import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;

public class ProductBuilder {

	private Long productId;
	private String name;

	public ProductBuilder withProductId(Long productId) {
		this.productId = productId;

		return this;
	}

	public ProductBuilder withName(String name) {
		this.name = name;

		return this;
	}

	public ProductDTO build() {
		return new ProductDTO(productId, name);
	}

}
