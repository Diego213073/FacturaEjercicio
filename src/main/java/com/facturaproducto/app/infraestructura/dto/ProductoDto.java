package com.facturaproducto.app.infraestructura.dto;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "productos")
public class ProductoDto extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private Double valor;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ProductoDto() {
	}

	public ProductoDto(String codigo, String nombre, Double valor) {
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.valor = valor;
	}

}