package com.facturaproducto.app.domain.models;

import com.facturaproducto.app.shared.domain.Codigo;
import com.facturaproducto.app.shared.domain.Nombre;
import com.facturaproducto.app.shared.domain.Valor;

public class Producto {

	private Codigo codigo;
	private Nombre nombre;
	private Valor valor;

	public static Producto of(Codigo codigo, Nombre nombre, Valor valor) {
		return new Producto(codigo, nombre, valor);
	}

	private Producto(Codigo codigo, Nombre nombre, Valor valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	public Codigo getCodigo() {
		return codigo;
	}

	public Nombre getNombre() {
		return nombre;
	}

	public Valor getValor() {
		return valor;
	}

}
