package com.facturaproducto.app.shared.domain;

import com.facturaproducto.app.exceptions.NombreNovalidoException;

public class Nombre {
	
	private final String value;

	public Nombre(String nombre) {
		try {
			this.value = nombre;
			if(!nombre.matches("[A-Z].*")) {
				throw new NombreNovalidoException();
			}
			
		}catch(NullPointerException e) {
			throw new NombreNovalidoException();
		}
	}
	
	public String getValue() {
		return value;
	}

}
