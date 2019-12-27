package com.facturaproducto.app.infraestructura.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "facturas")
@EntityListeners(AuditingEntityListener.class)
public class FacturaDto extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Double valorTotal;
	private String nombreCliente;
	@OneToMany(targetEntity = ItemDto.class, cascade = CascadeType.ALL)
	private List<ItemDto> items;

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

	public List<ItemDto> getItems() {
		return items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public FacturaDto() {}

}
