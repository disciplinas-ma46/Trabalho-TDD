package main;

import definicoes.Delimitador;
import estruturaEvolucoes.EvolucoesMemory;
import estruturaEvolucoes.EvolucoesTime;
import exceptions.ArquivoNaoEncontradoException;

class Menu {
	EvolucoesMemory memories = new EvolucoesMemory();
	EvolucoesTime times = new EvolucoesTime();
	LeitorArquivo leitor = new LeitorArquivo();
	
	Delimitador delimitador = new Delimitador();
	
	public boolean run() {
		try {
			//System.out.println("lendo");
			leitor.lerArquivo("analysisMemory.out", memories);
			leitor.lerArquivo("analysisTime.out", times);
			//System.out.println("lido");
		}
		catch(ArquivoNaoEncontradoException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		delimitador.definir();
		
		System.out.println("Delimitador lido: " + delimitador.getDelimitador());
		
		
		return true;
	}
	
}

public class Programa {
	
	public static void main(String[] args) {
		
		new Menu().run();
		
	}

}
