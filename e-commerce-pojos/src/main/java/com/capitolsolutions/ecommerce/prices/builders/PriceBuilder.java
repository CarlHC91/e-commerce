package com.capitolsolutions.ecommerce.prices.builders;

import java.util.Date;

import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.prices.pojos.PriceDTO;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;

public class PriceBuilder {

	private Long priceList;
	private BrandDTO brand;
	private Date startDate;
	private Date endDate;
	private ProductDTO product;
	private Long priority;
	private Double price;
	private String curr;

	public PriceBuilder withPriceList(Long priceList) {
		this.priceList = priceList;

		return this;
	}

	public PriceBuilder withBrand(BrandDTO brand) {
		this.brand = brand;

		return this;
	}

	public PriceBuilder withStartDate(Date startDate) {
		this.startDate = startDate;

		return this;
	}

	public PriceBuilder withEndDate(Date endDate) {
		this.endDate = endDate;

		return this;
	}

	public PriceBuilder withProduct(ProductDTO product) {
		this.product = product;

		return this;
	}

	public PriceBuilder withPriority(Long priority) {
		this.priority = priority;

		return this;
	}

	public PriceBuilder withPrice(Double price) {
		this.price = price;

		return this;
	}

	public PriceBuilder withCurr(String curr) {
		this.curr = curr;

		return this;
	}

	public PriceDTO build() {
		return new PriceDTO(priceList, brand, startDate, endDate, product, priority, price, curr);
	}

}
