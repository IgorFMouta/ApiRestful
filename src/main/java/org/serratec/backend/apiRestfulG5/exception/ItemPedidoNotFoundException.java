package org.serratec.backend.apiRestfulG5.exception;

public class ItemPedidoNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ItemPedidoNotFoundException(String message) {
		super(message);
	}
	
	public ItemPedidoNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public ItemPedidoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ItemPedidoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
