package com.facturaproducto.app.exceptions;

public class RegistroNoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegistroNoEncontradoException() {
		super("Registro no encontrado");
	}
}
