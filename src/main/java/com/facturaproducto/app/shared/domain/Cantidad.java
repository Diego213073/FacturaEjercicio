package com.facturaproducto.app.shared.domain;

import com.facturaproducto.app.exceptions.CantidadItemnoValidaException;

public class Cantidad extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final Integer value;

	public Cantidad(Integer value) {
		this.value = value;
		if (value < 0) 
			throw new CantidadItemnoValidaException();
		
	}

	public Integer getValue() {
		return value;
	}

}
