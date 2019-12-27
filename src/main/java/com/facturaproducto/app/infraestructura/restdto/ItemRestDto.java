package com.facturaproducto.app.infraestructura.restdto;

public class ItemRestDto {

	private String codigo;
	private Integer cantidad;
	private Double valorTotal;
	private ProductoRestDto producto;

	public ItemRestDto(String codigo, Integer cantidad, Double valorTotal, ProductoRestDto producto) {
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.valorTotal = valorTotal;
		this.producto = producto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

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

	public ProductoRestDto getProducto() {
		return producto;
	}

	public void setProducto(ProductoRestDto producto) {
		this.producto = producto;
	}

	public ItemRestDto() {
	}

}
