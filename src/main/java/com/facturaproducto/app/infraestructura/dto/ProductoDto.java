package com.facturaproducto.app.infraestructura.dto;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class ProductoDto extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private Double valor;
	

	public ProductoDto(String codigo, String nombre, Double valor) {
		this.nombre = nombre;
		this.setCodigo(codigo); //Utilizar herencia (recibir códgio)
		this.valor = valor;
	}

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
	


	public ProductoDto() {}

}
