package com.facturaproducto.app.exceptions;

public class CantidadItemnoValidaException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public CantidadItemnoValidaException() {
		super("Cantidad no válida");
	}
	
	

}
