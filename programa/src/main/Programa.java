package main;

import definicoes.CaminhoSaida;
import definicoes.Delimitador;
import definicoes.FormatoSaida;
import estruturaEvolucoes.EvolucoesMemory;
import estruturaEvolucoes.EvolucoesTime;
import exceptions.ArquivoNaoEncontradoException;
import exceptions.EscritaNaoPermitidaException;

class Menu {
	EvolucoesMemory memories = new EvolucoesMemory();
	EvolucoesTime times = new EvolucoesTime();
	LeitorArquivo leitor = new LeitorArquivo();
	EscritorArquivo escritor = new EscritorArquivo();
	
	Delimitador delimitador = new Delimitador();
	CaminhoSaida saida = new CaminhoSaida();
	FormatoSaida formato = new FormatoSaida();
	
	
	public boolean run() {
		try {
			leitor.lerArquivo("analysisMemory.out", memories);
			leitor.lerArquivo("analysisTime.out", times);
		}
		catch(ArquivoNaoEncontradoException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		delimitador.definir();
		System.out.println("Delimitador lido: " + delimitador.getDelimitador());

		try {
			saida.definir();
		} catch (EscritaNaoPermitidaException e) {
			System.out.println(e.getMessage());
			return false;
		}

		formato.definir();
		
		escritor.escreverArquivo(
				"analysisMemoryTab.out", 
				memories, 
				saida.getCaminhoSaida(), 
				delimitador.getDelimitador(), 
				formato.getFormatoSaida());
		
		escritor.escreverArquivo(
				"analysisTimeTab.out", 
				times, 
				saida.getCaminhoSaida(), 
				delimitador.getDelimitador(), 
				formato.getFormatoSaida());
		
		System.out.println("Finalizado");
		
		return true;
	}
	
}

public class Programa {
	public static void main(String[] args) {
		new Menu().run();
	}
}
