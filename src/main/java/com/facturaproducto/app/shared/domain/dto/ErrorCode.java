package com.facturaproducto.app.shared.domain.dto;


//Clase relacionada con ExceptionHandlers, los atributos guardarán un código auto-generado por UUID y un mensaje de error
public class ErrorCode {
	private String codigo;
	private String mensaje;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
