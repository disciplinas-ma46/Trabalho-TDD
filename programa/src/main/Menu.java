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
	Persistencia persistencia = new Persistencia();
	
	public boolean run() {
		try {
			persistencia.lerArquivo(memories);
			persistencia.lerArquivo(times);
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
		
		persistencia.escreverArquivo(this, memories);
		persistencia.escreverArquivo(this, times);
		
		System.out.println("Finalizado");
		
		return true;
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



