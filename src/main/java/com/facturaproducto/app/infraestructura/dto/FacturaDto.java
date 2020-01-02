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

	public FacturaDto(Double valorTotal, String nombreCliente, List<ItemDto> items) {
		this.valorTotal = valorTotal;
		this.nombreCliente = nombreCliente;
		this.items = items;
	}

	
	/*Constructor vacio para evitar errores al momento de configurar
	correctamente (setear) los datos con respecto a los campos que vienen del formulario
	*/
	public FacturaDto() {
	}

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

}
