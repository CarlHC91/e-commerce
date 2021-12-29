package com.capitolsolutions.ecommerce.model.entities.brands;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa la entidad 'grupos'
 * 
 * @author carlhc91
 */
@Entity
@Table(name = "BRANDS")
public class Brand {

	@Id
	@Column(name = "BRAND_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandId;

	@Column(name = "NAME")
	private String name;

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
	 * Metodo de consulta del nombre de grupo
	 * 
	 * @return nombre de grupo
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo de asignacion del nombre de grupo
	 * 
	 * @param name - nombre de grupo
	 */
	public void setName(String name) {
		this.name = name;
	}

}
