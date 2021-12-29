package com.capitolsolutions.ecommerce.model.entities.prices;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa la entidad 'precios'
 * 
 * @author carlhc91
 */
@Entity
@Table(name = "PRICES")
public class Price {

	@Id
	@Column(name = "PRICE_LIST")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long priceList;

	@Column(name = "BRAND_ID")
	private Long brandId;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRIORITY")
	private Long priority;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "CURR")
	private String curr;

	/**
	 * Metodo de consulta del identificador de precio
	 * 
	 * @return identificador de precio
	 */
	public Long getPriceList() {
		return priceList;
	}

	/**
	 * Metodo de asignacion del identifiador de precio
	 * 
	 * @param priceList - identificador de precio
	 */
	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	/**
	 * Metodo de consulta del identificador de grupo
	 * 
	 * @return identificador de grupo
	 */
	public Long getBrandId() {
		return brandId;
	}

	/**
	 * Metodo de asignacion del identificador de grupo
	 * 
	 * @param brandId - identificador de grupo
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	/**
	 * Metodo de consulta de la fecha de inicio de vigencia
	 * 
	 * @return fecha de inicio de vigencia
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Metodo de asignacion de la fecha de inicio de vigencia
	 * 
	 * @param startDate - fecha de inicio de vigencia
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Metodo de consulta de la fecha de fin de vigencia
	 * 
	 * @return fecha de fin de vigencia
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Metodo de asignacion nde la fecha de fin de vigencia
	 * 
	 * @param endDate - fecha de fin de vigencia
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Metodo de consulta del identificador de producto
	 * 
	 * @return identificador de producto
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * Metodo de asignacion del identificador de producto
	 * 
	 * @param productId - identificador de producto
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Metodo de consulta de prioridad.
	 * Utilizado para desanbiguacion de un precio
	 * en caso de que se encuentren varios vigentes a la vez
	 * 
	 * @return prioridad
	 */
	public Long getPriority() {
		return priority;
	}

	/**
	 * Metodo de asignacion de prioridad.
	 * Utilizado para desanbiguacion de un precio
	 * en caso de que se encuentren varios vigentes a la vez
	 * 
	 * @param priority - prioridad
	 */
	public void setPriority(Long priority) {
		this.priority = priority;
	}

	/**
	 * Metodo de consulta del precio del producto
	 * 
	 * @return precio del producto
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Metodo de asignacion del precio del producto
	 * 
	 * @param price - precio del producto
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Metodo de consulta de la divisa en formato ISO
	 * 
	 * @return divisa
	 */
	public String getCurr() {
		return curr;
	}

	/**
	 * Metodo de asignacion de la divisa en formato ISO
	 * 
	 * @param curr - divisa
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}

}
