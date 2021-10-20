package main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import estruturaEvolucoes.*;
import exceptions.ArquivoNaoEncontradoException;
	
//public LeitorArquivoMemoria

class Parser {
	// para dar Override
	public Object toNumber(String value) {
		return new Object();
	}
}

class ParserInt extends Parser{
	@Override
	public Object toNumber(String value) {
		return (Integer) Integer.parseInt(value);
	}
}

class ParserDouble extends Parser{
	@Override
	public Object toNumber(String value) {
		return (Double) Double.parseDouble(value);
	}
}

public class LeitorArquivo {
	
	private final String CAMINHO_PADRAO = "ide/";
	private Parser parser;
	
	public int lerArquivo(String nomeArquivo, Evolucoes evolucoes) throws ArquivoNaoEncontradoException {
		
		if (evolucoes.getClass() == EvolucoesMemory.class) {
			parser = new ParserDouble();
		}
		else if(evolucoes.getClass() == EvolucoesTime.class) {
			parser = new ParserInt();
		}
		
		try {
			String caminhoCompleto = CAMINHO_PADRAO + nomeArquivo;
			//System.out.println(caminhoCompleto);
			File myObj = new File(caminhoCompleto);
			Scanner myReader = new Scanner(myObj);
			
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	if(data.charAt(0) == '-') {
		    		evolucoes.adicionarEvolucao();
		    	}
		    	else {
		    		evolucoes.adicionarValor(parser.toNumber(data));
		    	}
		    	//System.out.println(data);
		    }
		    myReader.close();
		    return evolucoes.quantidadeEvolucoes();
		} catch (FileNotFoundException e) {
			//System.out.println("An error occurred.");
		    //e.printStackTrace();
			throw new ArquivoNaoEncontradoException("Arquivo " + nomeArquivo + " não encontrado");
		}
	}
	
}
