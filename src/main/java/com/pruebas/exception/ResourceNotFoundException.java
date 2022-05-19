package com.pruebas.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5175344525318533125L;
	
	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}
}
