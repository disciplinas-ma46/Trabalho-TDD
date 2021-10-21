package definicoes;

import java.util.Scanner;

import exceptions.DelimitadorInvalidoException;

public class Delimitador {
	private final char[] escapesLetra = {'b','f','n','r','t','\'','\"','\\'};
	private final char[] escapes = {'\b','\f','\n','\r','\t','\'','\"','\\'};
	private char delimitador;
	
	public char getDelimitador() {
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
	
	public void definir() {
		Scanner sc=new Scanner(System.in);
		boolean valido = false;
		while (!valido) {
			System.out.print("Digite o caractere delimitador: ");
			String caractere = sc.nextLine();
			try {
				delimitador = parseChar(caractere);
				valido = true;
			} catch (DelimitadorInvalidoException e) {
				System.out.println(e.getMessage());
			}
				
		}
		sc.close();
	}
	
	
}
