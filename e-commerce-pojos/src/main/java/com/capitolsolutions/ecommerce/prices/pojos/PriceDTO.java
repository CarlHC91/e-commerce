package com.capitolsolutions.ecommerce.prices.pojos;

import java.util.Date;

import com.capitolsolutions.ecommerce.brands.pojos.BrandDTO;
import com.capitolsolutions.ecommerce.products.pojos.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceDTO {

	@JsonProperty("price_list")
	private Long priceList;

	@JsonProperty("brand")
	private BrandDTO brand;

	@JsonProperty("start_date")
	private Date startDate;

	@JsonProperty("end_date")
	private Date endDate;

	@JsonProperty("product")
	private ProductDTO product;

	@JsonProperty("priority")
	private Long priority;

	@JsonProperty("price")
	private Double price;

	@JsonProperty("curr")
	private String curr;

	public PriceDTO(Long priceList, BrandDTO brand, Date startDate, Date endDate, ProductDTO product, Long priority, Double price, String curr) {
		this.priceList = priceList;
		this.brand = brand;
		this.startDate = startDate;
		this.endDate = endDate;
		this.product = product;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

}
