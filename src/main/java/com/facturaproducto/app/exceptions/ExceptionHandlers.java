package com.facturaproducto.app.exceptions;

import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

	private static final Logger LOG = Logger.getLogger(ExceptionHandlers.class.getName());

	
	
	// Recibiendo atributos de la clase Error code
	public void LogError(ErrorCode code, Exception e) {
		LOG.severe(code.getCodigo());
		LOG.severe(code.getMensaje());
		LOG.severe(e.getMessage());
	}
	
	
//
//	//En caso de un error fuera del rango
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(Exception.class)
//	public ErrorCode handlerException(Exception e) {
//		ErrorCode code = new ErrorCode();
//		code.setCodigo(this.generarId());
//		code.setMensaje("Error no controlado");
//		this.LogError(code, e);
//		return code;
//	}
	
	//Generar error de código 
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CodigoNovalidoException.class)
	public ErrorCode codigonovalido(Exception e) {
		ErrorCode code = new ErrorCode();
		code.setCodigo(this.generarId());
		code.setMensaje(e.getMessage());
		this.LogError(code, e);
		return code;
	}
	
	
	//Generar  error de nombre
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NombreNovalidoException.class)
	public ErrorCode nombreNovalido(Exception e) {
		ErrorCode code = new ErrorCode();
		code.setCodigo(this.generarId());
		code.setMensaje(e.getMessage());
		this.LogError(code, e);
		return code;
	}
	
	
	//Generar error de código
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValornovalidoException.class)
	public ErrorCode valorNovalido(Exception e) {
		ErrorCode code = new ErrorCode();
		code.setCodigo(this.generarId());
		code.setMensaje(e.getMessage());
		this.LogError(code, e);
		return code;
	}
	
	
	
	//Generar id y mostrarlo en consola
	private String generarId() {
		return UUID.randomUUID().toString();
	}

}
