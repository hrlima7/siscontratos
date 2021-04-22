package br.com.roma.Exception.storage;

public class StorageException extends RuntimeException {

	private static final long serialVersionUID = 1L;



	public StorageException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}



	public StorageException(String message, Throwable causa) {
		super(message, causa);

	}



}
