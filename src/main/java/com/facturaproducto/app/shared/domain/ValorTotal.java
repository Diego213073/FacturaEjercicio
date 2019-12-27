package com.facturaproducto.app.shared.domain;

import com.facturaproducto.app.exceptions.CantidadItemnoValidaException;

public class ValorTotal {

	private final Double value;

	public ValorTotal(Double value) {
		this.value = value;
		if (value <= 0) 
			throw new CantidadItemnoValidaException();
		
	}

	public Double getValue() {
		return value;
	}

}
