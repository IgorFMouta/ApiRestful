package org.serratec.backend.apiRestfulG5.exception;

public class FuncionarioNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public FuncionarioNotFoundException(String message) {
		super(message);
	}
	
	public FuncionarioNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public FuncionarioNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FuncionarioNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
