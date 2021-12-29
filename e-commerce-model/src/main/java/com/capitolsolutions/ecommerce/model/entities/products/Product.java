package com.capitolsolutions.ecommerce.model.entities.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa la entidad 'productos'
 * 
 * @author carlhc91
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(name = "NAME")
	private String name;

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
	 * Metodo de consulta del nombre de producto
	 * 
	 * @return nombre de producto
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo de asignacion del nombre de producto
	 * 
	 * @param name - nombre de producto
	 */
	public void setName(String name) {
		this.name = name;
	}

}
