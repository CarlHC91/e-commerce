package com.capitolsolutions.ecommerce.prices.builders;

import java.util.Date;

import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.prices.pojos.PriceFilterDTO;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;

public class PriceFilterBuilder {

	private BrandDTO brand;
	private Date queryDate;
	private ProductDTO product;

	public PriceFilterBuilder withBrand(BrandDTO brand) {
		this.brand = brand;

		return this;
	}

	public PriceFilterBuilder withQueryDate(Date queryDate) {
		this.queryDate = queryDate;

		return this;
	}

	public PriceFilterBuilder withProduct(ProductDTO product) {
		this.product = product;

		return this;
	}

	public PriceFilterDTO build() {
		return new PriceFilterDTO(brand, queryDate, product);
	}

}
