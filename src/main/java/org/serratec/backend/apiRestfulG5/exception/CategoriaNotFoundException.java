package org.serratec.backend.apiRestfulG5.exception;

public class CategoriaNotFoundException extends Exception {

private static final long serialVersionUID = 1L;
	
	public CategoriaNotFoundException() {
		
	}
	
	public CategoriaNotFoundException(String message) {
		super(message);
	}
	
	public CategoriaNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public CategoriaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CategoriaNotFoundException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
