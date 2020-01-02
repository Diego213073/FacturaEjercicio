package com.facturaproducto.app.domain.models;

import com.facturaproducto.app.shared.domain.Codigo;
import com.facturaproducto.app.shared.domain.Nombre;
import com.facturaproducto.app.shared.domain.Valor;

public class Producto {

	private Codigo codigo; //Código auto-generado mediante UUID 
	private Nombre nombre;
	private Valor valor;
	
	
	private Producto(Codigo codigo, Nombre nombre, Valor valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	
	//Retorna un producto(objeto) encapsulado, va a recibir código, nombre y valor.
	public static Producto of(Codigo codigo, Nombre nombre, Valor valor) {
		return new Producto(codigo, nombre, valor);
	}

	
    //Métodos get para acceder a los atributos encapsulados.
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
