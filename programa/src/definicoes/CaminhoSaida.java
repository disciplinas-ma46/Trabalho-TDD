package definicoes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

import exceptions.DelimitadorInvalidoException;
import exceptions.EscritaNaoPermitidaException;
import main.Uteis;

public class CaminhoSaida {
	
	private String caminhoSaida = ".\\saida\\";
	
	String getCaminhoSaida() {
		return caminhoSaida;
	}
	
	void definir() throws EscritaNaoPermitidaException{
		boolean valido = false;
		while (!valido) {
			caminhoSaida = Uteis.Input("Digite caminho da saída: ");
			
			if(!isValidPath(caminhoSaida)) {
				System.out.print("caminhito invalido, digite outro\n");
//				throw new EscritaNaoPermitidaException("Caminho " + caminhoSaida + " não permitido");
			}
			else {
				valido = true;
			}
		}
	}
	
	private boolean isValidPath(String path) {
		// falsificação
		caminhoSaida = ".\\" + path + "\\";
		return true;
//		System.out.println(path.split("\\")[0]);
//		File f = new File(".\\" + path + "\\placeholder.out");
//		boolean b = f.canWrite();
//		if(b) {
//			caminhoSaida = ".\\" + path + "\\";
//			return b;
//		}
//		File a = new File(path);
//		b = a.canWrite();
//		if(b) {
//			return b;
//		}
//		return false;
		
//		if(b
//		return f.canWrite();
//		return Files.isWritable(path);
//	    try {
//	        Paths.get(path);
//	    } catch (InvalidPathException | NullPointerException ex) {
//	        return false;
//	    }
//	    return true;
	}
	
}
