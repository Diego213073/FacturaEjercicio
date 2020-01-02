package com.facturaproducto.app.infraestructura.dto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ItemDto extends BaseEntity {


	private static final long serialVersionUID = 1L;
	private Integer cantidad;
	private Double valorTotal;

	@OneToOne(targetEntity = ProductoDto.class)
	private ProductoDto producto;

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ProductoDto getProducto() {
		return producto;
	}

	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}

	public ItemDto() {
		// TODO Auto-generated constructor stub
	}

	public ItemDto(String codigo, Integer cantidad, Double valorTotal, ProductoDto producto) {
		this.setCodigo(codigo);
		this.cantidad = cantidad;
		this.valorTotal = valorTotal;
		this.producto = producto;
	}

}
