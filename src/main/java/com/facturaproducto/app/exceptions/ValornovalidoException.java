package com.facturaproducto.app.exceptions;

public class ValornovalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValornovalidoException() {
		super("Valor ingreado no válido");
	}

}
