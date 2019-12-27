package com.facturaproducto.app.domain.models;

import java.util.List;

import com.facturaproducto.app.shared.domain.Codigo;
import com.facturaproducto.app.shared.domain.Nombre;
import com.facturaproducto.app.shared.domain.ValorTotal;

public class Factura {
	
	
	private final Codigo codigo;
	private final ValorTotal valorTotal;
	private final Nombre nombreCliente;
	private final List<Item> items;
	
	
	public static Factura of(Codigo codigo, ValorTotal valorTotal, Nombre nombreCliente, List<Item> items) {
		return new Factura(codigo, valorTotal, nombreCliente, items);
	}


	private Factura(Codigo codigo, ValorTotal valorTotal, Nombre nombreCliente, List<Item> items) {
		this.codigo = codigo;
		this.valorTotal = valorTotal;
		this.nombreCliente = nombreCliente;
		this.items = items;
	}


	public Codigo getCodigo() {
		return codigo;
	}


	public ValorTotal getValorTotal() {
		return valorTotal;
	}


	public Nombre getNombreCliente() {
		return nombreCliente;
	}


	public List<Item> getItems() {
		return items;
	}
	
	
	
	


}
