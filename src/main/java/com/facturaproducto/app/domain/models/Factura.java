package com.facturaproducto.app.domain.models;

import java.util.List;

import com.facturaproducto.app.shared.domain.Codigo;
import com.facturaproducto.app.shared.domain.Nombre;
import com.facturaproducto.app.shared.domain.ValorTotal;

public class Factura {

	private final Codigo codigo;
	private final ValorTotal valorTotal;
	private final Nombre nombreCliente;
	private final List<Item> items; // Lista de objetos de la clase Item.

	private Factura(Codigo codigo, ValorTotal valorTotal, Nombre nombreCliente, List<Item> items) {
		this.codigo = codigo;
		this.valorTotal = valorTotal;
		this.nombreCliente = nombreCliente;
		this.items = items;
	}

	// Método estático que retorna una factura (objeto)
	public static Factura of(Codigo codigo, ValorTotal valorTotal, Nombre nombreCliente, List<Item> items) {
		return new Factura(codigo, valorTotal, nombreCliente, items);
	}
	
	
    //Métodos get para acceder a los atributos encapsulados.
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
