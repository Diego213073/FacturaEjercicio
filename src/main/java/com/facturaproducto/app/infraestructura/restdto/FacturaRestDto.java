package com.facturaproducto.app.infraestructura.restdto;

import java.util.List;

public class FacturaRestDto {
	
	private String codigo;
	private Double valorTotal;
	private String nombreCliente;
	private List<ItemRestDto> items;
	
	
	public FacturaRestDto(String codigo, Double valorTotal, String nombreCliente, List<ItemRestDto> items) {
		this.codigo = codigo;
		this.valorTotal = valorTotal;
		this.nombreCliente = nombreCliente;
		this.items = items;
	}
	
	public FacturaRestDto() {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public List<ItemRestDto> getItems() {
		return items;
	}

	public void setItems(List<ItemRestDto> items) {
		this.items = items;
	}
	
	
	

}
