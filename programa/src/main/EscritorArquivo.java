package main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

import definicoes.Definicoes;
import estruturaEvolucoes.*;
import exceptions.ArquivoNaoEncontradoException;

public class EscritorArquivo {
	
	
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





