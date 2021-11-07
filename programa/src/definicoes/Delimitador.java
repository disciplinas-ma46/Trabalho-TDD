package definicoes;

import java.util.Scanner;

import exceptions.DelimitadorInvalidoException;
import main.Uteis;

public class Delimitador {
	private final char[] escapesLetra = {'b','f','n','r','t','\'','\"','\\'};
	private final char[] escapes = {'\b','\f','\n','\r','\t','\'','\"','\\'};
	private char delimitador = ';';
	
	char getDelimitador() {
		return delimitador;
	}
	
	private char parseChar(String caractere)  throws DelimitadorInvalidoException {
		if(caractere.length() == 0) {
			throw new DelimitadorInvalidoException("Caractere '" + caractere + "' inválido!");
		}
		if(caractere.length() == 1) {
			return caractere.charAt(0);
		}
		if(caractere.charAt(0) == '\\') {
			for(int i=0; i<escapesLetra.length; i++) {
				if(escapesLetra[i] == caractere.charAt(1)) {
					return escapes[i];
				}
			}
		}
		throw new DelimitadorInvalidoException("Caractere '" + caractere + "' inválido!");
	}
	
	void definir() {
		boolean valido = false;
		while (!valido) {
			String caractere = Uteis.Input("Digite o caractere delimitador: ");
			try {
				delimitador = parseChar(caractere);
				valido = true;
			} catch (DelimitadorInvalidoException e) {
				System.out.println(e.getMessage());
			}
				
		}
	}
	
	
}
