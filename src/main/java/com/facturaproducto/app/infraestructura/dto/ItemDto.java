package com.facturaproducto.app.infraestructura.dto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ItemDto extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer cantidad;
	private Double valortotal;

	@OneToOne(targetEntity = ProductoDto.class)
	private ProductoDto producto;

	public ItemDto(Integer cantidad, Double valortotal, ProductoDto producto) {
		this.cantidad = cantidad;
		this.valortotal = valortotal;
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValortotal() {
		return valortotal;
	}

	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}

	public ProductoDto getProducto() {
		return producto;
	}

	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ItemDto() {
	}

}
