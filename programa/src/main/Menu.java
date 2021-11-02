package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import definicoes.Definicoes;
import estruturaEvolucoes.Evolucoes;
import estruturaEvolucoes.EvolucoesMemory;
import estruturaEvolucoes.EvolucoesTime;
import exceptions.ArquivoNaoEncontradoException;
import exceptions.EscritaNaoPermitidaException;

public class Menu {
	EvolucoesMemory memories = new EvolucoesMemory();
	EvolucoesTime times = new EvolucoesTime();
	
	Definicoes definicoes = new Definicoes();
	
	
	public boolean run() {
		try {
			lerArquivo(memories);
			lerArquivo(times);
		}
		catch(ArquivoNaoEncontradoException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		definicoes.definirDelimitador();
		System.out.println("Delimitador lido: " + definicoes.getDelimitador());

		try {
			definicoes.definirCaminhoSaida();
		} catch (EscritaNaoPermitidaException e) {
			System.out.println(e.getMessage());
			return false;
		}

		definicoes.definirFormatoSaida();
		
		escreverArquivo(memories, definicoes);
		
		escreverArquivo(times, definicoes);
		
		System.out.println("Finalizado");
		
		return true;
	}
	
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
	
	public void escreverArquivo(Evolucoes evolucoes, Definicoes definicoes) {
		//definições
		String caminhoSaida = definicoes.getCaminhoSaida();
		char delimitador = definicoes.getDelimitador();
		String formato = definicoes.getFormatoSaida();
		
		String caminhoCompleto = caminhoSaida + evolucoes.getNomeSaida();
		
		File file = new File(caminhoCompleto);
		file.getParentFile().mkdirs();
		FileWriter writer;
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		if(formato == "L") {
			int i = 0;
			for(ArrayList<Object> evolucao : evolucoes.evolucoes) {
				try {
					writer.write("" + (i+1));
				
					for(Object valor : evolucao) {
						writer.write("" + delimitador + valor);
					}
					writer.write("\n");
					i++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(formato == "C") {
			try {
				//int i = 0;
				int maiorQuantidadeValores = evolucoes.quantidadeValores(0);
				
				int qtdEvolucoes = evolucoes.quantidadeEvolucoes();
			
				for (int i=0; i<qtdEvolucoes; i++) {
					int qtdValores = evolucoes.quantidadeValores(i);
					if(qtdValores > maiorQuantidadeValores) {
						maiorQuantidadeValores = qtdValores;
					}
					writer.write("" + (i+1));
					if(i != qtdEvolucoes-1) {
						writer.write("" + delimitador);
					}
				}
				writer.write("\n");
			
			
				for (int j=0; j<maiorQuantidadeValores; j++) {
					for (int i=0; i<qtdEvolucoes; i++) {
						Object valor = evolucoes.getValor(i, j);
						if(valor == null) {
							writer.write("   ");
						}
						else {
							writer.write("" + valor);
						}
						if(i != qtdEvolucoes-1) {
							writer.write("" + delimitador);
						}
					}
					writer.write("\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}


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



