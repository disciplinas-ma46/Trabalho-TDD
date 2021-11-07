package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import estruturaEvolucoes.Evolucoes;
import estruturaEvolucoes.EvolucoesMemory;
import exceptions.ArquivoNaoEncontradoException;

public class Persistencia {
	
	public int lerArquivo(Evolucoes evolucoes) throws ArquivoNaoEncontradoException{
		final String CAMINHO_PADRAO = "ide\\";
		Parser parser = new ParserInt();
		
		String nomeArquivo = evolucoes.getNomeEntrada();
		
		if (evolucoes.getClass() == EvolucoesMemory.class) {
			parser = new ParserDouble();
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
	
	public void escreverArquivo(Menu menu, Evolucoes evolucoes) {
		new EscreverArquivo(menu, evolucoes).compute();

	}
	
}
