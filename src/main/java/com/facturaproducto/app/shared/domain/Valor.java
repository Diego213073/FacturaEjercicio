package com.facturaproducto.app.shared.domain;

import com.facturaproducto.app.exceptions.ValornovalidoException;

public class Valor {
	
	private final Double value;

	public Valor(Double value) {
		if (value < 0)
			throw new ValornovalidoException();
		this.value = value;
	}


	public Double getValue() {
		return value;
	}

}
