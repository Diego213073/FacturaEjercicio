package com.facturaproducto.app.exceptions;

public class CodigoNovalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public CodigoNovalidoException() {
		super("Código ingresado no válido");
	}

}
