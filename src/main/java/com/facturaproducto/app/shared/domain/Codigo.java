package com.facturaproducto.app.shared.domain;

import com.facturaproducto.app.exceptions.CodigoNovalidoException;

public class Codigo {
	
	private final String value;

	public Codigo(String value) {
		if (value.length() > 64 || value.length() < 32)
			throw new CodigoNovalidoException();
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
