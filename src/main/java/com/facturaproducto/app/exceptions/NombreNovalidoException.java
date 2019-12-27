package com.facturaproducto.app.exceptions;

public class NombreNovalidoException  extends RuntimeException{
	

	private static final long serialVersionUID = 1L;
	public NombreNovalidoException() {
		super("Nombre ingresado no válido");
	}


}
