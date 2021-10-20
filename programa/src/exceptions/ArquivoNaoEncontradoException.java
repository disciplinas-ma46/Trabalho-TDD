package exceptions;

import java.io.FileNotFoundException;

public class ArquivoNaoEncontradoException extends FileNotFoundException {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	public ArquivoNaoEncontradoException(String errorMessage) {
		super(errorMessage);
	}
	
}
