package com.capitolsolutions.ecommerce.prices.pojos;

import java.util.Date;

import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceFilterDTO {

	@JsonProperty("brand")
	private BrandDTO brand;

	@JsonProperty("query_date")
	private Date queryDate;

	@JsonProperty("product")
	private ProductDTO product;

	public PriceFilterDTO(BrandDTO brand, Date queryDate, ProductDTO product) {
		super();
		this.brand = brand;
		this.queryDate = queryDate;
		this.product = product;
	}

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public Date getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

}
