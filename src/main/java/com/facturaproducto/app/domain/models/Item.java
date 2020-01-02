package com.facturaproducto.app.domain.models;

import com.facturaproducto.app.shared.domain.Cantidad;
import com.facturaproducto.app.shared.domain.Codigo;
import com.facturaproducto.app.shared.domain.ValorTotal;

public class Item {

	private final Codigo codigo;
	private final Producto producto; // Recibe un producto de la clase Producto.
	private final Cantidad cantidad;
	private final ValorTotal valorTotal;

	
	//Método estática que retorna un Item(objeto) que recibe código, producto, cantidad y valor_total.
	public static Item of(Codigo codigo, Cantidad cantidad, ValorTotal valorTotal, Producto producto) {
		return new Item(codigo, producto, cantidad, valorTotal);
	}

	//Constructor privado.
	private Item(Codigo codigo, Producto producto, Cantidad cantidad, ValorTotal valorTotal) {
		this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.valorTotal = valorTotal;
	}

	public Codigo getCodigo() {
		return codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public Cantidad getCantidad() {
		return cantidad;
	}

	public ValorTotal getValorTotal() {
		return valorTotal;
	}

}
